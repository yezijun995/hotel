package edu.fdzc.hotel.handler;

import edu.fdzc.hotel.vo.resp.BaseRespVO;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常捕获
 *
 * @author yezj
 * @date 2021/2/10 18:34
 */
public class WebGlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public BaseRespVO sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return BaseRespVO.error("该数据有关联数据，操作失败!");
        }
        return BaseRespVO.error("数据库异常，操作失败!");
    }
}
