package edu.fdzc.hotel.wineshop.service.impl;

import java.util.List;
import edu.fdzc.hotel.common.utils.DateUtils;
import edu.fdzc.hotel.wineshop.domain.HotelCheckIn;
import edu.fdzc.hotel.wineshop.mapper.HotelCheckInMapper;
import edu.fdzc.hotel.wineshop.service.IHotelCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 入住退房登记管理Service业务层处理
 * 
 * @author yifelix
 * @date 2021-02-16
 */
@Service
public class HotelCheckInServiceImpl implements IHotelCheckInService
{
    @Autowired
    private HotelCheckInMapper hotelCheckInMapper;

    /**
     * 查询入住退房登记管理
     * 
     * @param checkInId 入住退房登记管理ID
     * @return 入住退房登记管理
     */
    @Override
    public HotelCheckIn selectHotelCheckInById(Long checkInId)
    {
        return hotelCheckInMapper.selectHotelCheckInById(checkInId);
    }

    /**
     * 查询入住退房登记管理列表
     * 
     * @param hotelCheckIn 入住退房登记管理
     * @return 入住退房登记管理
     */
    @Override
    public List<HotelCheckIn> selectHotelCheckInList(HotelCheckIn hotelCheckIn)
    {
        return hotelCheckInMapper.selectHotelCheckInList(hotelCheckIn);
    }

    /**
     * 新增入住退房登记管理
     * 
     * @param hotelCheckIn 入住退房登记管理
     * @return 结果
     */
    @Override
    public int insertHotelCheckIn(HotelCheckIn hotelCheckIn)
    {
        hotelCheckIn.setCreateTime(DateUtils.getNowDate());
        return hotelCheckInMapper.insertHotelCheckIn(hotelCheckIn);
    }

    /**
     * 修改入住退房登记管理
     * 
     * @param hotelCheckIn 入住退房登记管理
     * @return 结果
     */
    @Override
    public int updateHotelCheckIn(HotelCheckIn hotelCheckIn)
    {
        hotelCheckIn.setUpdateTime(DateUtils.getNowDate());
        return hotelCheckInMapper.updateHotelCheckIn(hotelCheckIn);
    }

    /**
     * 批量删除入住退房登记管理
     * 
     * @param checkInIds 需要删除的入住退房登记管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelCheckInByIds(Long[] checkInIds)
    {
        return hotelCheckInMapper.deleteHotelCheckInByIds(checkInIds);
    }

    /**
     * 删除入住退房登记管理信息
     * 
     * @param checkInId 入住退房登记管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelCheckInById(Long checkInId)
    {
        return hotelCheckInMapper.deleteHotelCheckInById(checkInId);
    }
}
