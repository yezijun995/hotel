package edu.fdzc.hotel.wineshop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.fdzc.hotel.common.annotation.Excel;
import edu.fdzc.hotel.common.core.domain.BaseEntity;

/**
 * 留言管理对象 hotel_message
 * 
 * @author yifelix
 * @date 2021-02-16
 */
public class HotelMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long messageId;

    /** 酒店ID */
    private Long hotelId;

    /** 酒店名 */
    @Excel(name = "酒店名")
    private String hotelName;

    /** 用户ID */
    private Long hotelUserId;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 留言信息 */
    @Excel(name = "留言信息")
    private String content;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String icon;

    /** 上级留言ID */
    private Long parentMessageId;

    /** 是否删除 */
    private String delFlag;

    public void setMessageId(Long messageId) 
    {
        this.messageId = messageId;
    }

    public Long getMessageId() 
    {
        return messageId;
    }
    public void setHotelId(Long hotelId) 
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId() 
    {
        return hotelId;
    }
    public void setHotelName(String hotelName) 
    {
        this.hotelName = hotelName;
    }

    public String getHotelName() 
    {
        return hotelName;
    }
    public void setHotelUserId(Long hotelUserId) 
    {
        this.hotelUserId = hotelUserId;
    }

    public Long getHotelUserId() 
    {
        return hotelUserId;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setParentMessageId(Long parentMessageId) 
    {
        this.parentMessageId = parentMessageId;
    }

    public Long getParentMessageId() 
    {
        return parentMessageId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("messageId", getMessageId())
            .append("hotelId", getHotelId())
            .append("hotelName", getHotelName())
            .append("hotelUserId", getHotelUserId())
            .append("nickname", getNickname())
            .append("content", getContent())
            .append("icon", getIcon())
            .append("parentMessageId", getParentMessageId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
