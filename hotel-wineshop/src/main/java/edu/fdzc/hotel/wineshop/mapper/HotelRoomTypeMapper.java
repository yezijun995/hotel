package edu.fdzc.hotel.wineshop.mapper;

import edu.fdzc.hotel.wineshop.domain.HotelRoomType;

import java.util.List;

/**
 * 房间类型Mapper接口
 * 
 * @author yifelix
 * @date 2021-02-12
 */
public interface HotelRoomTypeMapper 
{
    /**
     * 查询房间类型
     * 
     * @param roomTypeId 房间类型ID
     * @return 房间类型
     */
    public HotelRoomType selectHotelRoomTypeById(Long roomTypeId);

    /**
     * 查询房间类型列表
     * 
     * @param hotelRoomType 房间类型
     * @return 房间类型集合
     */
    public List<HotelRoomType> selectHotelRoomTypeList(HotelRoomType hotelRoomType);

    /**
     * 新增房间类型
     * 
     * @param hotelRoomType 房间类型
     * @return 结果
     */
    public int insertHotelRoomType(HotelRoomType hotelRoomType);

    /**
     * 修改房间类型
     * 
     * @param hotelRoomType 房间类型
     * @return 结果
     */
    public int updateHotelRoomType(HotelRoomType hotelRoomType);

    /**
     * 删除房间类型
     * 
     * @param roomTypeId 房间类型ID
     * @return 结果
     */
    public int deleteHotelRoomTypeById(Long roomTypeId);

    /**
     * 批量删除房间类型
     * 
     * @param roomTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotelRoomTypeByIds(Long[] roomTypeIds);
}
