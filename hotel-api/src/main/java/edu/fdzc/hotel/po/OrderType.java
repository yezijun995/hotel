package edu.fdzc.hotel.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单类型表(OrderType)实体类
 *
 * @author yezj
 * @since 2021-02-10 16:41:32
 */
public class OrderType implements Serializable {
    private static final long serialVersionUID = 597226440266053544L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 类型名
     */
    private String typeName;
    /**
     * 酒店ID
     */
    private Long hotel;
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

    private String state;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getHotel() {
        return hotel;
    }

    public void setHotel(Long hotel) {
        this.hotel = hotel;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
