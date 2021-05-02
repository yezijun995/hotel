package edu.fdzc.hotel.wineshop.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yezj
 * @date 2021/5/2 16:07
 */
@Data
public class AccountInfoVO {

    /** 用户Id */
    private Long userId;

    /** 用户名 */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /** 身份证 */
    private String idCard;

    /*# 电话 */
    private String phone;

    /** 邮箱 */
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /** 地址 */
    private String address;

    /** 用户类型0:客户 1:用户 */
    @NotNull(message = "用户类型不能为空")
    private Byte userType;
}
