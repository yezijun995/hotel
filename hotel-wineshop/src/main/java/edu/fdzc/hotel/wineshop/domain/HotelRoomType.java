package edu.fdzc.hotel.wineshop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.fdzc.hotel.common.annotation.Excel;
import edu.fdzc.hotel.common.core.domain.BaseEntity;

/**
 * 房间类型对象 hotel_room_type
 * 
 * @author yifelix
 * @date 2021-02-12
 */
public class HotelRoomType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long roomTypeId;

    /** 类型名 */
    @Excel(name = "类型名")
    private String typeName;

    /** 房间大小 */
    @Excel(name = "房间大小")
    private Long area;

    /** 床位 */
    @Excel(name = "床位")
    private Long bedNum;

    /** 床位大小 */
    @Excel(name = "床位大小")
    private Long bedSize;

    /** 窗户 */
    @Excel(name = "窗户")
    private String window;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 折扣 */
    @Excel(name = "折扣")
    private Long discount;

    /** 创建人 */
    private Long createor;

    /** 更新人 */
    private Long updater;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 是否删除 */
    private String delFlag;

    public void setRoomTypeId(Long roomTypeId) 
    {
        this.roomTypeId = roomTypeId;
    }

    public Long getRoomTypeId() 
    {
        return roomTypeId;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setArea(Long area) 
    {
        this.area = area;
    }

    public Long getArea() 
    {
        return area;
    }
    public void setBedNum(Long bedNum) 
    {
        this.bedNum = bedNum;
    }

    public Long getBedNum() 
    {
        return bedNum;
    }
    public void setBedSize(Long bedSize) 
    {
        this.bedSize = bedSize;
    }

    public Long getBedSize() 
    {
        return bedSize;
    }
    public void setWindow(String window) 
    {
        this.window = window;
    }

    public String getWindow() 
    {
        return window;
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
    public void setCreateor(Long createor) 
    {
        this.createor = createor;
    }

    public Long getCreateor() 
    {
        return createor;
    }
    public void setUpdater(Long updater) 
    {
        this.updater = updater;
    }

    public Long getUpdater() 
    {
        return updater;
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
            .append("roomTypeId", getRoomTypeId())
            .append("typeName", getTypeName())
            .append("area", getArea())
            .append("bedNum", getBedNum())
            .append("bedSize", getBedSize())
            .append("window", getWindow())
            .append("price", getPrice())
            .append("discount", getDiscount())
            .append("createor", getCreateor())
            .append("createTime", getCreateTime())
            .append("updater", getUpdater())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
