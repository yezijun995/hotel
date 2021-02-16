package edu.fdzc.hotel.wineshop.mapper;

import edu.fdzc.hotel.wineshop.domain.HotelCheckIn;

import java.util.List;

/**
 * 入住退房登记管理Mapper接口
 * 
 * @author yifelix
 * @date 2021-02-16
 */
public interface HotelCheckInMapper 
{
    /**
     * 查询入住退房登记管理
     * 
     * @param checkInId 入住退房登记管理ID
     * @return 入住退房登记管理
     */
    public HotelCheckIn selectHotelCheckInById(Long checkInId);

    /**
     * 查询入住退房登记管理列表
     * 
     * @param hotelCheckIn 入住退房登记管理
     * @return 入住退房登记管理集合
     */
    public List<HotelCheckIn> selectHotelCheckInList(HotelCheckIn hotelCheckIn);

    /**
     * 新增入住退房登记管理
     * 
     * @param hotelCheckIn 入住退房登记管理
     * @return 结果
     */
    public int insertHotelCheckIn(HotelCheckIn hotelCheckIn);

    /**
     * 修改入住退房登记管理
     * 
     * @param hotelCheckIn 入住退房登记管理
     * @return 结果
     */
    public int updateHotelCheckIn(HotelCheckIn hotelCheckIn);

    /**
     * 删除入住退房登记管理
     * 
     * @param checkInId 入住退房登记管理ID
     * @return 结果
     */
    public int deleteHotelCheckInById(Long checkInId);

    /**
     * 批量删除入住退房登记管理
     * 
     * @param checkInIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotelCheckInByIds(Long[] checkInIds);
}
