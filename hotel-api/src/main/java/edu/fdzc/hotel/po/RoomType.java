package edu.fdzc.hotel.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 房间类型表(RoomType)实体类
 *
 * @author yezj
 * @since 2021-02-10 16:41:32
 */
public class RoomType implements Serializable {
    private static final long serialVersionUID = 220469540737649530L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 类型名
     */
    private String typeName;
    /**
     * 房间区域
     */
    private Integer area;
    /**
     * 床位
     */
    private Integer bedNum;
    /**
     * 床位大小
     */
    private Integer bedSize;
    /**
     * 0:没有、1:有窗、2:有落地窗
     */
    private String window;
    /**
     * 价格
     */
    private Object price;
    /**
     * 折扣
     */
    private Object discount;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public Integer getBedSize() {
        return bedSize;
    }

    public void setBedSize(Integer bedSize) {
        this.bedSize = bedSize;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getDiscount() {
        return discount;
    }

    public void setDiscount(Object discount) {
        this.discount = discount;
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
