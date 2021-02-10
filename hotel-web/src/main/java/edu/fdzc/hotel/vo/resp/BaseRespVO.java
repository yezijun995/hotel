package edu.fdzc.hotel.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一返回格式
 *
 * @author yezj
 * @date 2021/2/10 18:41
 */
@ApiModel(value = "BaseRespVO", description = "web返回对象")
public class BaseRespVO<T> implements Serializable {

    private static final long serialVersionUID = 2138445752493858946L;

    private boolean success = true;

    @ApiModelProperty(name = "errorCode", value = "错误编码")
    private String errorCode;

    @ApiModelProperty(name = "errorMessage", value = "错误信息")
    private String errorMessage;

    private T data;

    public BaseRespVO() {
    }

    public BaseRespVO(MsgType e) {
        this.errorCode = e.getCode();
        this.errorMessage = e.getMsg();
    }

    public BaseRespVO(MsgType e, T data) {
        this.errorCode = e.getCode();
        this.errorMessage = e.getMsg();
        this.data = data;
    }

    public BaseRespVO(MsgType e, String msg, T data) {
        this.errorCode = e.getCode();
        this.errorMessage = msg;
        this.data = data;
    }

    public BaseRespVO(MsgType e, String msg) {
        this.errorCode = e.getCode();
        this.errorMessage = msg;
    }

    public BaseRespVO(String code, String msg) {
        this.errorCode = code;
        this.errorMessage = msg;
    }

    public static BaseRespVO build() {
        return new BaseRespVO<>();
    }

    public static BaseRespVO error(MsgType respStatus) {
        BaseRespVO responseVO = new BaseRespVO(respStatus, respStatus.getMsg());
        responseVO.success = false;
        return responseVO;
    }

    public static BaseRespVO error(String msg) {
        BaseRespVO responseVO = new BaseRespVO(MsgType.ERROR, msg);
        responseVO.success = false;
        return responseVO;
    }

    public static BaseRespVO error(String code, String msg) {
        BaseRespVO responseVO = new BaseRespVO(code, msg);
        responseVO.success = false;
        return responseVO;
    }

    public static <T> BaseRespVO<T> success(T data) {
        return new BaseRespVO(MsgType.SUCCESS, MsgType.SUCCESS.getMsg(), data);
    }

    public static <T> BaseRespVO<T> success(String msg, T data) {
        return new BaseRespVO(MsgType.SUCCESS, msg, data);
    }

    public BaseRespVO status(MsgType e) {
        this.errorCode = e.getCode();
        this.errorMessage = e.getMsg();
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
