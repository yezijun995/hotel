package edu.fdzc.hotel.vo.resp;

/**
 * 消息类型描述
 * @author yezj
 * @date 2021/2/10 18:47
 */
public enum MsgType {

    SUCCESS("200", "服务器成功返回请求的数据"),
    DATA_CHANGE_SUCCESS("201","新建或修改数据成功"),
    DELETE_SUCCESS("204","删除数据成功"),
    CHECK_ERROR("300", "校验错误"),
    ACL_REFUSE("401", "用户没有权限（令牌、用户名、密码错误）"),
    VISIT_REFUSE("403","用户得到授权，但是访问是被禁止的"),
    NOT_FOUND("404","发出的请求针对的是不存在的记录，服务器没有进行操作"),
    ERROR("500", "系统异常"),
    UNLOGIN("600", "账户未登录"),
    ACCOUNT_EXPIRED("601", "账号过期");

    private String code;
    private String msg;

    MsgType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
