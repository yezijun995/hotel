package edu.fdzc.hotel.wineshop.service.impl;

import edu.fdzc.hotel.common.enums.OrderStatus;
import edu.fdzc.hotel.wineshop.domain.HotelCheckIn;
import edu.fdzc.hotel.wineshop.domain.HotelOrders;
import edu.fdzc.hotel.wineshop.domain.HotelRoom;
import edu.fdzc.hotel.wineshop.mapper.HotelCheckInMapper;
import edu.fdzc.hotel.wineshop.mapper.HotelOrdersMapper;
import edu.fdzc.hotel.wineshop.mapper.HotelRoomMapper;
import edu.fdzc.hotel.wineshop.service.IHotelCheckInService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 入住退房登记管理Service业务层处理
 *
 * @author yifelix
 * @date 2021-02-16
 */
@Service
public class HotelCheckInServiceImpl implements IHotelCheckInService {
    @Resource
    private HotelCheckInMapper hotelCheckInMapper;

    @Resource
    private HotelOrdersMapper hotelOrdersMapper;

    @Resource
    private HotelRoomMapper hotelRoomMapper;

    /**
     * 查询入住退房登记管理
     *
     * @param checkInId 入住退房登记管理ID
     * @return 入住退房登记管理
     */
    @Override
    public HotelCheckIn selectHotelCheckInById(Long checkInId) {
        return hotelCheckInMapper.selectHotelCheckInById(checkInId);
    }

    /**
     * 查询入住退房登记管理列表
     *
     * @param hotelCheckIn 入住退房登记管理
     * @return 入住退房登记管理
     */
    @Override
    public List<HotelCheckIn> selectHotelCheckInList(HotelCheckIn hotelCheckIn) {
        return hotelCheckInMapper.selectHotelCheckInList(hotelCheckIn);
    }

    /**
     * 新增入住退房登记管理
     *
     * @param hotelCheckIn 入住退房登记管理
     * @return 结果
     */
    @Override
    public int insertHotelCheckIn(HotelCheckIn hotelCheckIn) {
        return hotelCheckInMapper.insertHotelCheckIn(hotelCheckIn);
    }

    /**
     * 修改入住退房登记管理
     *
     * @param hotelCheckIn 入住退房登记管理
     * @return 结果
     */
    @Override
    public int updateHotelCheckIn(HotelCheckIn hotelCheckIn) {
        return hotelCheckInMapper.updateHotelCheckIn(hotelCheckIn);
    }

    /**
     * 入住房间管理
     *
     * @param hotelCheckIn
     * @return
     */
    @Transactional
    @Override
    public int checkIn(HotelCheckIn hotelCheckIn) {
        //修改订单表数据
        HotelOrders orders = hotelOrdersMapper.selectHotelOrdersById(hotelCheckIn.getOrdersId());
        orders.setOrderState(OrderStatus.CHECK_IN.getCode() + "");
        if (!Objects.equals(hotelOrdersMapper.updateHotelOrders(orders), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -3;
        }
        hotelCheckIn.setStatus(OrderStatus.CHECK_IN.getCode() + "");
        if (!Objects.equals(hotelCheckInMapper.updateHotelCheckIn(hotelCheckIn), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -2;
        }
        return 1;
    }

    @Transactional
    @Override
    public int cancel(Long checkInId) {
        HotelCheckIn hotelCheckIn = hotelCheckInMapper.selectHotelCheckInById(checkInId);

        hotelCheckIn.setStatus(OrderStatus.WAS_CANCELED.getCode() + "");
        //取消订单表数据
        HotelOrders orders = hotelOrdersMapper.selectHotelOrdersById(hotelCheckIn.getOrdersId());
        orders.setOrderState(OrderStatus.WAS_CANCELED.getCode() + "");
        if (!Objects.equals(hotelOrdersMapper.updateHotelOrders(orders), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -3;
        }
        //修改房间预订
        HotelRoom hotelRoom = hotelRoomMapper.selectHotelRoomById(orders.getRoomId());
        hotelRoom.setStatus("1");
        if (!Objects.equals(hotelRoomMapper.updateHotelRoom(hotelRoom), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -2;
        }
        if(!Objects.equals(hotelCheckInMapper.updateHotelCheckIn(hotelCheckIn), 1)){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }
        return 1;
    }

    @Override
    @Transactional
    public int checkOut(Long checkInId) {
        HotelCheckIn hotelCheckIn = hotelCheckInMapper.selectHotelCheckInById(checkInId);
        hotelCheckIn.setStatus(OrderStatus.CHECK_OUT.getCode() + "");

        //修改订单表数据
        HotelOrders orders = hotelOrdersMapper.selectHotelOrdersById(hotelCheckIn.getOrdersId());
        orders.setOrderState(OrderStatus.CHECK_OUT.getCode() + "");

        if (!Objects.equals(hotelOrdersMapper.updateHotelOrders(orders), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -3;
        }
        //修改房间预订
        HotelRoom hotelRoom = hotelRoomMapper.selectHotelRoomById(orders.getRoomId());
        hotelRoom.setStatus("1");
        if (!Objects.equals(hotelRoomMapper.updateHotelRoom(hotelRoom), 1)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -2;
        }

        if(!Objects.equals(hotelCheckInMapper.updateHotelCheckIn(hotelCheckIn), 1)){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }
        return 1;
    }

    /**
     * 批量删除入住退房登记管理
     *
     * @param checkInIds 需要删除的入住退房登记管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelCheckInByIds(Long[] checkInIds) {
        return hotelCheckInMapper.deleteHotelCheckInByIds(checkInIds);
    }

    /**
     * 删除入住退房登记管理信息
     *
     * @param checkInId 入住退房登记管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelCheckInById(Long checkInId) {
        return hotelCheckInMapper.deleteHotelCheckInById(checkInId);
    }

    @Override
    public int cancelCheckIn(Long orderId) {
        return hotelCheckInMapper.cancelCheckIn(orderId);
    }
}
