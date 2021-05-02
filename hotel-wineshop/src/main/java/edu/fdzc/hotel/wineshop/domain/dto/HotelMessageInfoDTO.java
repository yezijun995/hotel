package edu.fdzc.hotel.wineshop.domain.dto;

import edu.fdzc.hotel.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yezj
 * @date 2021/5/2 12:05
 */
@Data
public class HotelMessageInfoDTO extends BaseEntity {

    private static final long serialVersionUID = -7444609423958944253L;

    /** 主键 */
    private Long messageId;

    /** 酒店ID */
    private Long hotelId;

    /** 用户ID */
    private Long userId;

    /** 昵称 */
    private String nickname;

    /** 留言信息 */
    private String content;

    /** 头像地址 */
    private String icon;

    /** 上级留言ID */
    private Long parentMessageId;

    //回复留言
    private List<HotelMessageInfoDTO> replyMessages = new ArrayList<>();

    /*相联父类昵称*/
    private String parentNickname;

}
