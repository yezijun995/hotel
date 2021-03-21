package edu.fdzc.hotel.wineshop.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import edu.fdzc.hotel.common.annotation.Excel;
import edu.fdzc.hotel.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 入住退房登记管理对象 hotel_check_in
 *
 * @author yifelix
 * @date 2021-03-21
 */
public class HotelCheckIn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long checkInId;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long ordersId;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNumber;

    /** 酒店ID */
    private Long hotelId;

    /** 房间类型 */
    private Long roomTypeId;

    /** 酒店名 */
    @Excel(name = "酒店名")
    private String hotelName;

    /** 入住人数 */
    @Excel(name = "入住人数")
    private Long perCount;

    /** 入住人 */
    @Excel(name = "入住人")
    private String persons;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 入住时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkInTime;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 是否删除 */
    private String delFlag;

    public void setCheckInId(Long checkInId)
    {
        this.checkInId = checkInId;
    }

    public Long getCheckInId()
    {
        return checkInId;
    }
    public void setOrdersId(Long ordersId)
    {
        this.ordersId = ordersId;
    }

    public Long getOrdersId()
    {
        return ordersId;
    }
    public void setRoomNumber(String roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber()
    {
        return roomNumber;
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
    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getHotelName()
    {
        return hotelName;
    }
    public void setPerCount(Long perCount)
    {
        this.perCount = perCount;
    }

    public Long getPerCount()
    {
        return perCount;
    }
    public void setPersons(String persons)
    {
        this.persons = persons;
    }

    public String getPersons()
    {
        return persons;
    }
    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getIdCard()
    {
        return idCard;
    }
    public void setCheckInTime(Date checkInTime)
    {
        this.checkInTime = checkInTime;
    }

    public Date getCheckInTime()
    {
        return checkInTime;
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
                .append("checkInId", getCheckInId())
                .append("ordersId", getOrdersId())
                .append("roomNumber", getRoomNumber())
                .append("hotelId", getHotelId())
                .append("roomTypeId", getRoomTypeId())
                .append("hotelName", getHotelName())
                .append("perCount", getPerCount())
                .append("persons", getPersons())
                .append("idCard", getIdCard())
                .append("checkInTime", getCheckInTime())
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
