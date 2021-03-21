package edu.fdzc.hotel.wineshop.service;

import edu.fdzc.hotel.wineshop.domain.HotelRoom;

import java.util.List;

/**
 * 房间管理Service接口
 *
 * @author yifelix
 * @date 2021-02-13
 */
public interface IHotelRoomService {
    /**
     * 查询房间管理
     *
     * @param roomId 房间管理ID
     * @return 房间管理
     */
    public HotelRoom selectHotelRoomById(Long roomId);

    /**
     * 查询房间管理列表
     *
     * @param hotelRoom 房间管理
     * @return 房间管理集合
     */
    public List<HotelRoom> selectHotelRoomList(HotelRoom hotelRoom);

    /**
     * 新增房间管理
     *
     * @param hotelRoom 房间管理
     * @return 结果
     */
    public int insertHotelRoom(HotelRoom hotelRoom);

    /**
     * 修改房间管理
     *
     * @param hotelRoom 房间管理
     * @return 结果
     */
    public int updateHotelRoom(HotelRoom hotelRoom);

    /**
     * 批量删除房间管理
     *
     * @param roomIds 需要删除的房间管理ID
     * @return 结果
     */
    public int deleteHotelRoomByIds(Long[] roomIds);

    /**
     * 删除房间管理信息
     *
     * @param roomId 房间管理ID
     * @return 结果
     */
    public int deleteHotelRoomById(Long roomId);

    /**
     * 检测酒店下的房间是否是唯一
     *
     * @param hotelId
     * @param roomName
     * @return
     */
    String checkRoomNameUnique(Long hotelId, String roomName);
}
