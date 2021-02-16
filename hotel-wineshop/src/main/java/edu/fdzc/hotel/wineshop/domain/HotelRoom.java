package edu.fdzc.hotel.wineshop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.fdzc.hotel.common.annotation.Excel;
import edu.fdzc.hotel.common.core.domain.BaseEntity;

/**
 * 房间管理对象 hotel_room
 * 
 * @author yifelix
 * @date 2021-02-13
 */
public class HotelRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long roomId;

    /** 房间号 */
    @Excel(name = "房间号")
    private String number;

    /** 类型ID */
    private Long typeId;

    /** 酒店ID */
    private Long hotelId;

    /** 类型名 */
    @Excel(name = "类型名")
    private String typeName;

    /** 酒店名 */
    private String hotelName;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 折扣 */
    @Excel(name = "折扣")
    private Long discount;

    /** 房间状态 */
    @Excel(name = "房间状态")
    private String status;

    /** 是否删除 */
    private String delFlag;

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setHotelId(Long hotelId) 
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId() 
    {
        return hotelId;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setHotelName(String hotelName) 
    {
        this.hotelName = hotelName;
    }

    public String getHotelName() 
    {
        return hotelName;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setDiscount(Long discount) 
    {
        this.discount = discount;
    }

    public Long getDiscount() 
    {
        return discount;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("roomId", getRoomId())
            .append("number", getNumber())
            .append("typeId", getTypeId())
            .append("hotelId", getHotelId())
            .append("typeName", getTypeName())
            .append("hotelName", getHotelName())
            .append("price", getPrice())
            .append("discount", getDiscount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
