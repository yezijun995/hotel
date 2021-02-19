package edu.fdzc.hotel.wineshop.service.impl;

import java.util.List;

import edu.fdzc.hotel.common.constant.UserConstants;
import edu.fdzc.hotel.common.utils.DateUtils;
import edu.fdzc.hotel.wineshop.domain.HotelRoom;
import edu.fdzc.hotel.wineshop.mapper.HotelRoomMapper;
import edu.fdzc.hotel.wineshop.service.IHotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 房间管理Service业务层处理
 * 
 * @author yifelix
 * @date 2021-02-13
 */
@Service
public class HotelRoomServiceImpl implements IHotelRoomService
{
    @Autowired
    private HotelRoomMapper hotelRoomMapper;

    /**
     * 查询房间管理
     * 
     * @param roomId 房间管理ID
     * @return 房间管理
     */
    @Override
    public HotelRoom selectHotelRoomById(Long roomId)
    {
        return hotelRoomMapper.selectHotelRoomById(roomId);
    }

    /**
     * 查询房间管理列表
     * 
     * @param hotelRoom 房间管理
     * @return 房间管理
     */
    @Override
    public List<HotelRoom> selectHotelRoomList(HotelRoom hotelRoom)
    {
        return hotelRoomMapper.selectHotelRoomList(hotelRoom);
    }

    /**
     * 新增房间管理
     * 
     * @param hotelRoom 房间管理
     * @return 结果
     */
    @Override
    public int insertHotelRoom(HotelRoom hotelRoom)
    {
        return hotelRoomMapper.insertHotelRoom(hotelRoom);
    }

    /**
     * 修改房间管理
     * 
     * @param hotelRoom 房间管理
     * @return 结果
     */
    @Override
    public int updateHotelRoom(HotelRoom hotelRoom)
    {
        return hotelRoomMapper.updateHotelRoom(hotelRoom);
    }

    /**
     * 批量删除房间管理
     * 
     * @param roomIds 需要删除的房间管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelRoomByIds(Long[] roomIds)
    {
        return hotelRoomMapper.deleteHotelRoomByIds(roomIds);
    }

    /**
     * 删除房间管理信息
     * 
     * @param roomId 房间管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelRoomById(Long roomId)
    {
        return hotelRoomMapper.deleteHotelRoomById(roomId);
    }

    @Override
    public String checkRoomNameUnique(Long hotelId,String roomName) {
        int count = hotelRoomMapper.checkRoomNameUnique(hotelId,roomName);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
