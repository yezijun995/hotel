package edu.fdzc.hotel.common.core.domain.entity;

import edu.fdzc.hotel.common.annotation.Excel;
import edu.fdzc.hotel.common.core.domain.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yezj
 * @date 2021/3/13 16:55
 */
@Data
public class SysAccount extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long accountId;

    /** 登录名 */
    @Excel(name = "登录名")
    @NotBlank(message = "登录名不能为空")
    private String accountName;

    /** 密码 */
    @Excel(name = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    /** 昵称 */
    @Excel(name = "昵称")
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realName;

    /** 生日 */
    @Excel(name = "生日")
    private String birth;

    /** 签名 */
    @Excel(name = "签名")
    private String sign;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String icon;

    /** 0:未知、1:男，2:女 */
    @Excel(name = "0:未知、1:男，2:女")
    private String gender;

    /** $column.columnComment */
    @NotBlank(message = "电话不能为空")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 身份证 */
    @Excel(name = "身份证")
    private String idCard;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 是否删除 */
    private String delFlag;
}
