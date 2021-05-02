package edu.fdzc.hotel.wineshop.service.impl;

import edu.fdzc.hotel.common.constant.Constants;
import edu.fdzc.hotel.common.utils.bean.BeanUtils;
import edu.fdzc.hotel.wineshop.domain.HotelMessage;
import edu.fdzc.hotel.wineshop.domain.dto.HotelMessageInfoDTO;
import edu.fdzc.hotel.wineshop.mapper.HotelMessageMapper;
import edu.fdzc.hotel.wineshop.service.IHotelMessageService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 留言管理Service业务层处理
 *
 * @author yifelix
 * @date 2021-02-16
 */
@Service
public class HotelMessageServiceImpl implements IHotelMessageService {
    @Autowired
    private HotelMessageMapper hotelMessageMapper;

    /**
     * 查询留言管理
     *
     * @param messageId 留言管理ID
     * @return 留言管理
     */
    @Override
    public HotelMessage selectHotelMessageById(Long messageId) {
        return hotelMessageMapper.selectHotelMessageById(messageId);
    }

    @Override
    public List<HotelMessageInfoDTO> selectHotelMessageInfo(Long hotelId) {
        List<HotelMessage> hotelMessages = hotelMessageMapper.selectHotelMessageInfo(hotelId);
        if (CollectionUtils.isNotEmpty(hotelMessages)) {
            List<HotelMessage> parentMessage = hotelMessages.stream()
                    .filter(hotelMessage -> Objects.equals(hotelMessage.getParentMessageId(), Constants.DEFAULT_PARENT_ID))
                    .collect(Collectors.toList());
            List<HotelMessageInfoDTO> parentMessageInfos = BeanUtils.convertObjectList(parentMessage, HotelMessageInfoDTO.class);
            return parentMessageInfos;
        }
        return null;
    }


    /**
     * 查询留言管理列表
     *
     * @param hotelMessage 留言管理
     * @return 留言管理
     */
    @Override
    public List<HotelMessage> selectHotelMessageList(HotelMessage hotelMessage) {
        return hotelMessageMapper.selectHotelMessageList(hotelMessage);
    }

    /**
     * 新增留言管理
     *
     * @param hotelMessage 留言管理
     * @return 结果
     */
    @Override
    public int insertHotelMessage(HotelMessage hotelMessage) {
        hotelMessage.setCreateTime(new Date());
        if (Objects.isNull(hotelMessage.getParentMessageId())) {
            hotelMessage.setParentMessageId(Constants.DEFAULT_PARENT_ID);
        }
        return hotelMessageMapper.insertHotelMessage(hotelMessage);
    }

    /**
     * 修改留言管理
     *
     * @param hotelMessage 留言管理
     * @return 结果
     */
    @Override
    public int updateHotelMessage(HotelMessage hotelMessage) {
        return hotelMessageMapper.updateHotelMessage(hotelMessage);
    }

    /**
     * 批量删除留言管理
     *
     * @param messageIds 需要删除的留言管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelMessageByIds(Long[] messageIds) {
        return hotelMessageMapper.deleteHotelMessageByIds(messageIds);
    }

    /**
     * 删除留言管理信息
     *
     * @param messageId 留言管理ID
     * @return 结果
     */
    @Override
    public int deleteHotelMessageById(Long messageId) {
        return hotelMessageMapper.deleteHotelMessageById(messageId);
    }

    @Override
    public Long getMessageCount() {
        return hotelMessageMapper.getMessageCount();
    }
}
