package edu.fdzc.hotel.configuration.handler;

import com.alibaba.fastjson.JSON;
import edu.fdzc.hotel.vo.resp.BaseRespVO;
import edu.fdzc.hotel.vo.resp.MsgType;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 会话失效，账号被挤下线处理
 *
 * @author yezj
 * @date 2021/2/10 23:38
 */
@Component
public class SessionInformationExpiredStrategy implements org.springframework.security.web.session.SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        BaseRespVO respVO = BaseRespVO.build().status(MsgType.USER_ACCOUNT_USE_BY_OTHERS);
        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(respVO));
    }
}
