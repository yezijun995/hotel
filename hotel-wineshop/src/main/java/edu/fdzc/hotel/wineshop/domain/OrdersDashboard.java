package edu.fdzc.hotel.wineshop.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yezj
 * @date 2021/3/26 0:00
 */
@Data
public class OrdersDashboard implements Serializable {

    private static final long serialVersionUID = -991651698140756316L;

    /**
     * 订单状态
     */
    private String orderState;

    /**
     * 订单数量
     */
    private Long count;
}
