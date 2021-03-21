package edu.fdzc.hotel.wineshop.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yezj
 * @date 2021/3/21 0:40
 */
@Data
public class PayOrdersVO {

    @NotNull(message = "订单号不能为空")
    private Long orderId;

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
}
