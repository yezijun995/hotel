package edu.fdzc.hotel.wineshop.service;

import edu.fdzc.hotel.wineshop.domain.HotelMessage;
import edu.fdzc.hotel.wineshop.domain.dto.HotelMessageInfoDTO;

import java.util.List;

/**
 * 留言管理Service接口
 * 
 * @author yifelix
 * @date 2021-02-16
 */
public interface IHotelMessageService 
{
    /**
     * 查询留言管理
     * 
     * @param messageId 留言管理ID
     * @return 留言管理
     */
    public HotelMessage selectHotelMessageById(Long messageId);

    /**
     * 根据酒店Id查询留言信息
     * @param hotelId
     * @return
     */
    List<HotelMessageInfoDTO> selectHotelMessageInfo(Long hotelId);

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
     * 批量删除留言管理
     * 
     * @param messageIds 需要删除的留言管理ID
     * @return 结果
     */
    public int deleteHotelMessageByIds(Long[] messageIds);

    /**
     * 删除留言管理信息
     * 
     * @param messageId 留言管理ID
     * @return 结果
     */
    public int deleteHotelMessageById(Long messageId);

    /**
     * 获取留言数量
     * @return
     */
    Long getMessageCount();
}
