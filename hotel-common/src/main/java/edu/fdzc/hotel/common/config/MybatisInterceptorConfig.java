package edu.fdzc.hotel.common.config;

import edu.fdzc.hotel.common.interceptor.AutoFillInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yezj
 * @date 2021/2/19 17:35
 */
@Configuration
public class MybatisInterceptorConfig {
    @Bean
    public String myInterceptor(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addInterceptor(new AutoFillInterceptor());
        return "interceptor";
    }
}
