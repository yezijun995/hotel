package edu.fdzc.hotel.controller;

import edu.fdzc.hotel.vo.resp.BaseRespVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yezj
 * @date 2021/2/10 18:59
 */
@RequestMapping("/")
@RestController
public class IndexController {

    @RequestMapping(value = {"/","/login"})
    public BaseRespVO index() {
        return BaseRespVO.error("尚未登录，请登录");
    }
}
