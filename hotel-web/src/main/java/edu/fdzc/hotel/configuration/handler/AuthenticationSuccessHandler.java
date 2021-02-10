package edu.fdzc.hotel.configuration.handler;

import com.alibaba.fastjson.JSON;
import edu.fdzc.hotel.vo.resp.BaseRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理
 *
 * @author yezj
 * @date 2021/2/10 20:50
 */
@Component
@Slf4j
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        BaseRespVO responseVO = BaseRespVO.success("登录成功", user);
        httpServletResponse.getWriter().write(JSON.toJSONString(responseVO));
        log.info(user.getUsername() + "登出成功！");
    }
}
