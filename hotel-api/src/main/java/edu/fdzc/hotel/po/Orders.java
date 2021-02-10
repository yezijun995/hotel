package edu.fdzc.hotel.po;

import java.util.Date;
import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author yezj
 * @since 2021-02-10 16:41:32
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = 387347535105043574L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 订单类型ID
     */
    private Long typeId;
    /**
     * 订单类型名
     */
    private String typeName;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机
     */
    private String phone;
    /**
     * 酒店ID
     */
    private Long hotelId;
    /**
     * 房间类型ID
     */
    private Long roomTypeId;
    /**
     * 房间类型
     */
    private String roomTypeName;
    /**
     * 房间ID
     */
    private Long roomId;
    /**
     * 房间数
     */
    private Integer numOfRoom;
    /**
     * 预订天数
     */
    private Integer orderDays;
    /**
     * 预订时间
     */
    private Date orderDate;
    /**
     * 预订状态
     */
    private String orderState;
    /**
     * 预订费用
     */
    private Object orderCost;
    /**
     * 创建人
     */
    private Long createor;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Long updater;
    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer state;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否删除
     */
    private Byte deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(Integer numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public Integer getOrderDays() {
        return orderDays;
    }

    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Object getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Object orderCost) {
        this.orderCost = orderCost;
    }

    public Long getCreateor() {
        return createor;
    }

    public void setCreateor(Long createor) {
        this.createor = createor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

}
