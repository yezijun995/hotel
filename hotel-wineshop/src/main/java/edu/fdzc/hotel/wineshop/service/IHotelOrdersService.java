package edu.fdzc.hotel.wineshop.service;

import edu.fdzc.hotel.wineshop.domain.HotelOrders;

import java.util.List;

/**
 * 订单管理Service接口
 * 
 * @author yifelix
 * @date 2021-02-16
 */
public interface IHotelOrdersService 
{
    /**
     * 查询订单管理
     * 
     * @param ordersId 订单管理ID
     * @return 订单管理
     */
    public HotelOrders selectHotelOrdersById(Long ordersId);

    /**
     * 查询订单管理列表
     * 
     * @param hotelOrders 订单管理
     * @return 订单管理集合
     */
    public List<HotelOrders> selectHotelOrdersList(HotelOrders hotelOrders);

    /**
     * 新增订单管理
     * 
     * @param hotelOrders 订单管理
     * @return 结果
     */
    public int insertHotelOrders(HotelOrders hotelOrders);

    /**
     * 修改订单管理
     * 
     * @param hotelOrders 订单管理
     * @return 结果
     */
    public int updateHotelOrders(HotelOrders hotelOrders);

    /**
     * 批量删除订单管理
     * 
     * @param ordersIds 需要删除的订单管理ID
     * @return 结果
     */
    public int deleteHotelOrdersByIds(Long[] ordersIds);

    /**
     * 删除订单管理信息
     * 
     * @param ordersId 订单管理ID
     * @return 结果
     */
    public int deleteHotelOrdersById(Long ordersId);

    /**
     * 根据用户Id查询订单
     * @param userId
     * @return
     */
    List<HotelOrders> getAllOrderByUser(Long userId);

    /**
     * 支付订单
     * @param orderId
     * @return
     */
    int payOrder(Long orderId);

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    int cancelOrder(Long orderId);

    /**
     * 获取金额
     * @return
     */
    Double getEarnMoney();

    /**
     * 获取订单数
     * @return
     */
    Long getOrderCount();
}
