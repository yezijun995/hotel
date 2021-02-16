package edu.fdzc.hotel.wineshop.mapper;

import java.util.List;
import edu.fdzc.hotel.wineshop.domain.HotelMessage;

/**
 * 留言管理Mapper接口
 * 
 * @author yifelix
 * @date 2021-02-16
 */
public interface HotelMessageMapper 
{
    /**
     * 查询留言管理
     * 
     * @param messageId 留言管理ID
     * @return 留言管理
     */
    public HotelMessage selectHotelMessageById(Long messageId);

    /**
     * 查询留言管理列表
     * 
     * @param hotelMessage 留言管理
     * @return 留言管理集合
     */
    public List<HotelMessage> selectHotelMessageList(HotelMessage hotelMessage);

    /**
     * 新增留言管理
     * 
     * @param hotelMessage 留言管理
     * @return 结果
     */
    public int insertHotelMessage(HotelMessage hotelMessage);

    /**
     * 修改留言管理
     * 
     * @param hotelMessage 留言管理
     * @return 结果
     */
    public int updateHotelMessage(HotelMessage hotelMessage);

    /**
     * 删除留言管理
     * 
     * @param messageId 留言管理ID
     * @return 结果
     */
    public int deleteHotelMessageById(Long messageId);

    /**
     * 批量删除留言管理
     * 
     * @param messageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotelMessageByIds(Long[] messageIds);
}
