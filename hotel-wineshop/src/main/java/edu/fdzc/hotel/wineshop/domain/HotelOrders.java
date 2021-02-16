package edu.fdzc.hotel.wineshop.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.fdzc.hotel.common.annotation.Excel;
import edu.fdzc.hotel.common.core.domain.BaseEntity;

/**
 * 订单管理对象 hotel_orders
 * 
 * @author yifelix
 * @date 2021-02-16
 */
public class HotelOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long ordersId;

    /** 订单类型ID */
    @Excel(name = "订单类型ID")
    private Long ordersTypeId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 酒店ID */
    @Excel(name = "酒店ID")
    private Long hotelId;

    /** 类型ID */
    @Excel(name = "类型ID")
    private Long roomTypeId;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private String roomTypeName;

    /** 房间ID */
    private Long roomId;

    /** 房间数 */
    @Excel(name = "房间数")
    private Long numOfRoom;

    /** 预订天数 */
    @Excel(name = "预订天数")
    private Long orderDays;

    /** 预订时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 预订状态 */
    @Excel(name = "预订状态")
    private String orderState;

    /** 预订费用 */
    @Excel(name = "预订费用")
    private Long orderCost;

    /** 状态 */
    private String status;

    /** 是否删除 */
    private String delFlag;

    public void setOrdersId(Long ordersId) 
    {
        this.ordersId = ordersId;
    }

    public Long getOrdersId() 
    {
        return ordersId;
    }
    public void setOrdersTypeId(Long ordersTypeId) 
    {
        this.ordersTypeId = ordersTypeId;
    }

    public Long getOrdersTypeId() 
    {
        return ordersTypeId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setHotelId(Long hotelId) 
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId() 
    {
        return hotelId;
    }
    public void setRoomTypeId(Long roomTypeId) 
    {
        this.roomTypeId = roomTypeId;
    }

    public Long getRoomTypeId() 
    {
        return roomTypeId;
    }
    public void setRoomTypeName(String roomTypeName) 
    {
        this.roomTypeName = roomTypeName;
    }

    public String getRoomTypeName() 
    {
        return roomTypeName;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setNumOfRoom(Long numOfRoom) 
    {
        this.numOfRoom = numOfRoom;
    }

    public Long getNumOfRoom() 
    {
        return numOfRoom;
    }
    public void setOrderDays(Long orderDays) 
    {
        this.orderDays = orderDays;
    }

    public Long getOrderDays() 
    {
        return orderDays;
    }
    public void setOrderDate(Date orderDate) 
    {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() 
    {
        return orderDate;
    }
    public void setOrderState(String orderState) 
    {
        this.orderState = orderState;
    }

    public String getOrderState() 
    {
        return orderState;
    }
    public void setOrderCost(Long orderCost) 
    {
        this.orderCost = orderCost;
    }

    public Long getOrderCost() 
    {
        return orderCost;
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
            .append("ordersId", getOrdersId())
            .append("ordersTypeId", getOrdersTypeId())
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("phone", getPhone())
            .append("hotelId", getHotelId())
            .append("roomTypeId", getRoomTypeId())
            .append("roomTypeName", getRoomTypeName())
            .append("roomId", getRoomId())
            .append("numOfRoom", getNumOfRoom())
            .append("orderDays", getOrderDays())
            .append("orderDate", getOrderDate())
            .append("orderState", getOrderState())
            .append("orderCost", getOrderCost())
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
