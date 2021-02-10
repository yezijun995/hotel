package edu.fdzc.hotel.configuration;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fdzc.hotel.configuration.handler.AuthenticationFailureHandler;
import edu.fdzc.hotel.configuration.handler.AuthenticationSuccessHandler;
import edu.fdzc.hotel.configuration.handler.LogoutSuccessHandler;
import edu.fdzc.hotel.configuration.handler.SessionInformationExpiredStrategy;
import edu.fdzc.hotel.service.impl.UserServiceImpl;
import edu.fdzc.hotel.vo.resp.BaseRespVO;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

/**
 * @author yezj
 * @date 2021/2/10 20:06
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DetailsServiceImpl detailsService;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;



    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @ConditionalOnMissingBean(name = {"daoAuthenticationProvider"})
    @Bean({"daoAuthenticationProvider"})
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.detailsService);
        provider.setHideUserNotFoundExceptions(false);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * 密码加密器
     */
    @Bean({"passwordEncoder"})
    public PasswordEncoder passwordEncoder() {
        return new MD5PwdEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被SpringSecurity拦截的问题
        web.ignoring().antMatchers("/css/**",
                "/js/**",
                "/index.html",
                "/img/**",
                "/fonts/**",
                "/favicon.ico",
                "/swagger-ui.html",
                "/swagger-resources/**"
        );
    }


    /**
     * Http安全配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();

        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/login") //登录url
                .permitAll()    //允许所有用户
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .logout()
                .logoutUrl("/api/logout")  //登出url
                .permitAll()
                .logoutSuccessHandler(logoutSuccessHandler)
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()    //没有认证
                .authenticationEntryPoint((req, resp, authException) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    resp.setStatus(404);
                    resp.setContentType("application/json;charset=utf-8");
                    BaseRespVO responseVO = BaseRespVO.error("没有权限，请登录");
                    resp.getWriter().write(JSON.toJSONString(responseVO));
                })
                .and()
                .sessionManagement()
                .maximumSessions(2)     //同一账户最大登录数
                .expiredSessionStrategy(sessionInformationExpiredStrategy);    //会话失效(账号被挤下线)处理逻辑
    }


}
