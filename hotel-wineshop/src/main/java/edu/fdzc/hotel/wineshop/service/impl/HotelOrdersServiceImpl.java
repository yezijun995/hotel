package edu.fdzc.hotel.wineshop.service.impl;

import edu.fdzc.hotel.common.enums.OrderStatus;
import edu.fdzc.hotel.wineshop.domain.HotelCheckIn;
import edu.fdzc.hotel.wineshop.domain.HotelOrders;
import edu.fdzc.hotel.wineshop.domain.HotelRoom;
import edu.fdzc.hotel.wineshop.mapper.HotelOrdersMapper;
import edu.fdzc.hotel.wineshop.mapper.HotelRoomMapper;
import edu.fdzc.hotel.wineshop.service.IHotelOrdersService;
import edu.fdzc.hotel.wineshop.service.IHotelRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 订单管理Service业务层处理
 *
 * @author yifelix
 * @date 2021-02-16
 */
@Service
public class HotelOrdersServiceImpl implements IHotelOrdersService {
    @Resource
    private HotelOrdersMapper hotelOrdersMapper;

    @Resource
    private IHotelRoomService hotelRoomService;

    @Resource
    private HotelRoomMapper hotelRoomMapper;

    /**
     * 查询订单管理
     *
     * @param ordersId 订单管理ID
     * @return 订单管理
     */
    @Override
    public HotelOrders selectHotelOrdersById(Long ordersId) {
        return hotelOrdersMapper.selectHotelOrdersById(ordersId);
    }

    /**
     * 查询订单管理列表
     *
     * @param hotelOrders 订单管理
     * @return 订单管理
     */
    @Override
    public List<HotelOrders> selectHotelOrdersList(HotelOrders hotelOrders) {
        return hotelOrdersMapper.selectHotelOrdersList(hotelOrders);
    }

    /**
     * 新增订单管理
     *
     * @param hotelOrders 订单管理
     * @return 结果
     */
    @Override
    public int insertHotelOrders(HotelOrders hotelOrders) {
        return hotelOrdersMapper.insertHotelOrders(hotelOrders);
    }

    /**
     * 修改订单管理
     *
     * @param hotelOrders 订单管理
     * @return 结果
     */
    @Override
    public int updateHotelOrders(HotelOrders hotelOrders) {
        return hotelOrdersMapper.updateHotelOrders(hotelOrders);
    }

    /**
     * 批量删除订单管理
     *
     * @param ordersIds 需要删除的订单管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelOrdersByIds(Long[] ordersIds) {
        return hotelOrdersMapper.deleteHotelOrdersByIds(ordersIds);
    }

    /**
     * 删除订单管理信息
     *
     * @param ordersId 订单管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelOrdersById(Long ordersId) {
        return hotelOrdersMapper.deleteHotelOrdersById(ordersId);
    }

    @Override
    public List<HotelOrders> getAllOrderByUser(Long userId) {
        return hotelOrdersMapper.getAllOrderByUser(userId);
    }

    /**
     * 订单支付
     * 1.更改订单状态 -3
     * 2.修改房型余量 -2
     * 3.修改房间状态 -1
     *
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    public int payOrder(Long orderId) {
        HotelOrders orders = hotelOrdersMapper.selectHotelOrdersById(orderId);

        if (Objects.isNull(orders) || !Objects.equals(orders.getOrderState(), OrderStatus.UNPAID.getCode() + "")) {
            return -3;
        }

        List<HotelRoom> hotelRooms = hotelRoomMapper.selectHotelRoomByTypeId(orders.getRoomTypeId());
        //下单的房间
        HotelRoom hotelRoom = hotelRooms.get(0);
        hotelRoom.setStatus("0");
        hotelRoomMapper.updateHotelRoom(hotelRoom);

        orders.setRoomId(hotelRoom.getRoomId());
        orders.setNumOfRoom(Long.valueOf(hotelRoom.getNumber()));
        orders.setOrderState(OrderStatus.PAID.getCode() + "");
        if (!Objects.equals(hotelOrdersMapper.updateHotelOrders(orders), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        //下单到流水表

        return 1;
    }

    private int addCheckIn(HotelOrders orders){
        HotelCheckIn hotelCheckIn = new HotelCheckIn();
//        hotelCheckIn.setMenuName();
        return 1;
    }

    /**
     * 取消订单
     * 1. 更改订单状态 -3
     * 2. 修改房型余量（已付款）-2
     *
     * @param orderId
     * @return
     */
    @Override
    public int cancelOrder(Long orderId) {
        HotelOrders orders = hotelOrdersMapper.selectHotelOrdersById(orderId);
        if (Objects.isNull(orders)) {
            return -3;
        }
        orders.setOrderState(OrderStatus.WAS_CANCELED.getCode() + "");
        if (!Objects.equals(hotelOrdersMapper.updateHotelOrders(orders), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -2;
        }
        return 1;
    }
}
