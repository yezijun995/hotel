package edu.fdzc.hotel.configuration.handler;

import com.alibaba.fastjson.JSON;
import edu.fdzc.hotel.vo.resp.BaseRespVO;
import edu.fdzc.hotel.vo.resp.MsgType;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理
 *
 * @author yezj
 * @date 2021/2/10 21:39
 */
@Component
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json数据
        BaseRespVO result = null;
        if (e instanceof AccountExpiredException) {
            //账号过期
            result = BaseRespVO.build().status(MsgType.ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = BaseRespVO.build().status(MsgType.USER_CREDENTIALS_ERROR);
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = BaseRespVO.build().status(MsgType.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = BaseRespVO.build().status(MsgType.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            result = BaseRespVO.build().status(MsgType.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //认证异常
            result = BaseRespVO.build().status(MsgType.AUTHENTICATION_ERROR);
        }else if(e instanceof UsernameNotFoundException){
            result = BaseRespVO.build().status(MsgType.USER_ACCOUNT_NOT_EXIST);
        } else  {
            //其他错误
            result = BaseRespVO.build().status(MsgType.ERROR);
        }
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
