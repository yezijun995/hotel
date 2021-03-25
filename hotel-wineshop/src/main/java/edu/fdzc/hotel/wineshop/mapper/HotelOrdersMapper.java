package edu.fdzc.hotel.wineshop.mapper;

import edu.fdzc.hotel.wineshop.domain.HotelOrders;

import java.util.List;

/**
 * 订单管理Mapper接口
 * 
 * @author yifelix
 * @date 2021-02-16
 */
public interface HotelOrdersMapper 
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
     * 删除订单管理
     * 
     * @param ordersId 订单管理ID
     * @return 结果
     */
    public int deleteHotelOrdersById(Long ordersId);

    /**
     * 批量删除订单管理
     * 
     * @param ordersIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotelOrdersByIds(Long[] ordersIds);

    /**
     * 根据用户Id查询订单
     * @param userId
     * @return
     */
    List<HotelOrders> getAllOrderByUser(Long userId);

    Double getEarnMoney();

    Long getOrderCount();
}
