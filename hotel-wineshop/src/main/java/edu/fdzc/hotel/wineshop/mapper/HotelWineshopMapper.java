package edu.fdzc.hotel.wineshop.mapper;

import java.util.List;
import edu.fdzc.hotel.wineshop.domain.HotelWineshop;

/**
 * 酒店Mapper接口
 * 
 * @author yifelix
 * @date 2021-02-12
 */
public interface HotelWineshopMapper 
{
    /**
     * 查询酒店
     * 
     * @param hotelId 酒店ID
     * @return 酒店
     */
    public HotelWineshop selectHotelWineshopById(Long hotelId);

    /**
     * 查询酒店列表
     * 
     * @param hotelWineshop 酒店
     * @return 酒店集合
     */
    public List<HotelWineshop> selectHotelWineshopList(HotelWineshop hotelWineshop);

    /**
     * 新增酒店
     * 
     * @param hotelWineshop 酒店
     * @return 结果
     */
    public int insertHotelWineshop(HotelWineshop hotelWineshop);

    /**
     * 修改酒店
     * 
     * @param hotelWineshop 酒店
     * @return 结果
     */
    public int updateHotelWineshop(HotelWineshop hotelWineshop);

    /**
     * 删除酒店
     * 
     * @param hotelId 酒店ID
     * @return 结果
     */
    public int deleteHotelWineshopById(Long hotelId);

    /**
     * 批量删除酒店
     * 
     * @param hotelIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotelWineshopByIds(Long[] hotelIds);

    /**
     * 校验酒店名是否唯一
     * @param wineshopName
     * @return
     */
    int checkWineshopNameUnique(String wineshopName);
}
