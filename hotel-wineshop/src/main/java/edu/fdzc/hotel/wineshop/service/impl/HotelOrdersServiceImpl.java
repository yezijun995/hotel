package edu.fdzc.hotel.wineshop.service.impl;

import java.util.List;
import edu.fdzc.hotel.common.utils.DateUtils;
import edu.fdzc.hotel.wineshop.domain.HotelOrders;
import edu.fdzc.hotel.wineshop.mapper.HotelOrdersMapper;
import edu.fdzc.hotel.wineshop.service.IHotelOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单管理Service业务层处理
 * 
 * @author yifelix
 * @date 2021-02-16
 */
@Service
public class HotelOrdersServiceImpl implements IHotelOrdersService
{
    @Autowired
    private HotelOrdersMapper hotelOrdersMapper;

    /**
     * 查询订单管理
     * 
     * @param ordersId 订单管理ID
     * @return 订单管理
     */
    @Override
    public HotelOrders selectHotelOrdersById(Long ordersId)
    {
        return hotelOrdersMapper.selectHotelOrdersById(ordersId);
    }

    /**
     * 查询订单管理列表
     * 
     * @param hotelOrders 订单管理
     * @return 订单管理
     */
    @Override
    public List<HotelOrders> selectHotelOrdersList(HotelOrders hotelOrders)
    {
        return hotelOrdersMapper.selectHotelOrdersList(hotelOrders);
    }

    /**
     * 新增订单管理
     * 
     * @param hotelOrders 订单管理
     * @return 结果
     */
    @Override
    public int insertHotelOrders(HotelOrders hotelOrders)
    {
        hotelOrders.setCreateTime(DateUtils.getNowDate());
        return hotelOrdersMapper.insertHotelOrders(hotelOrders);
    }

    /**
     * 修改订单管理
     * 
     * @param hotelOrders 订单管理
     * @return 结果
     */
    @Override
    public int updateHotelOrders(HotelOrders hotelOrders)
    {
        hotelOrders.setUpdateTime(DateUtils.getNowDate());
        return hotelOrdersMapper.updateHotelOrders(hotelOrders);
    }

    /**
     * 批量删除订单管理
     * 
     * @param ordersIds 需要删除的订单管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelOrdersByIds(Long[] ordersIds)
    {
        return hotelOrdersMapper.deleteHotelOrdersByIds(ordersIds);
    }

    /**
     * 删除订单管理信息
     * 
     * @param ordersId 订单管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelOrdersById(Long ordersId)
    {
        return hotelOrdersMapper.deleteHotelOrdersById(ordersId);
    }
}
