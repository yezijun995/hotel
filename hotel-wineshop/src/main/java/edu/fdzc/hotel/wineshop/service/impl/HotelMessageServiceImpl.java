package edu.fdzc.hotel.wineshop.service.impl;

import java.util.List;
import edu.fdzc.hotel.common.utils.DateUtils;
import edu.fdzc.hotel.wineshop.domain.HotelMessage;
import edu.fdzc.hotel.wineshop.mapper.HotelMessageMapper;
import edu.fdzc.hotel.wineshop.service.IHotelMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 留言管理Service业务层处理
 * 
 * @author yifelix
 * @date 2021-02-16
 */
@Service
public class HotelMessageServiceImpl implements IHotelMessageService
{
    @Autowired
    private HotelMessageMapper hotelMessageMapper;

    /**
     * 查询留言管理
     * 
     * @param messageId 留言管理ID
     * @return 留言管理
     */
    @Override
    public HotelMessage selectHotelMessageById(Long messageId)
    {
        return hotelMessageMapper.selectHotelMessageById(messageId);
    }

    /**
     * 查询留言管理列表
     * 
     * @param hotelMessage 留言管理
     * @return 留言管理
     */
    @Override
    public List<HotelMessage> selectHotelMessageList(HotelMessage hotelMessage)
    {
        return hotelMessageMapper.selectHotelMessageList(hotelMessage);
    }

    /**
     * 新增留言管理
     * 
     * @param hotelMessage 留言管理
     * @return 结果
     */
    @Override
    public int insertHotelMessage(HotelMessage hotelMessage)
    {
        hotelMessage.setCreateTime(DateUtils.getNowDate());
        return hotelMessageMapper.insertHotelMessage(hotelMessage);
    }

    /**
     * 修改留言管理
     * 
     * @param hotelMessage 留言管理
     * @return 结果
     */
    @Override
    public int updateHotelMessage(HotelMessage hotelMessage)
    {
        hotelMessage.setUpdateTime(DateUtils.getNowDate());
        return hotelMessageMapper.updateHotelMessage(hotelMessage);
    }

    /**
     * 批量删除留言管理
     * 
     * @param messageIds 需要删除的留言管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelMessageByIds(Long[] messageIds)
    {
        return hotelMessageMapper.deleteHotelMessageByIds(messageIds);
    }

    /**
     * 删除留言管理信息
     * 
     * @param messageId 留言管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelMessageById(Long messageId)
    {
        return hotelMessageMapper.deleteHotelMessageById(messageId);
    }
}
