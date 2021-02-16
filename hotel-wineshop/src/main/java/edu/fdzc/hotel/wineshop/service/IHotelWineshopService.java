package edu.fdzc.hotel.wineshop.service;

import java.util.List;

import edu.fdzc.hotel.common.core.domain.TreeSelect;
import edu.fdzc.hotel.common.core.domain.entity.SysRole;
import edu.fdzc.hotel.wineshop.domain.HotelWineshop;

/**
 * 酒店Service接口
 *
 * @author yifelix
 * @date 2021-02-12
 */
public interface IHotelWineshopService {
    /**
     * 查询酒店
     *
     * @param hotelId 酒店ID
     * @return 酒店
     */
    public HotelWineshop selectHotelWineshopById(Long hotelId);

    /**
     * 校验角色是否允许操作
     *
     * @param hotelWineshop 酒店信息
     */
    public void checkRoleAllowed(HotelWineshop hotelWineshop);

    /**
     * 修改酒店状态
     *
     * @param hotelWineshop 酒店信息
     * @return 结果
     */
    public int updateWineshopStatus(HotelWineshop hotelWineshop);

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
     * 构建前端所需要下拉树结构
     *
     * @param wineshops
     * @return
     */
    List<TreeSelect> buildWineshopTreeSelect(List<HotelWineshop> wineshops);

    /**
     * 修改酒店
     *
     * @param hotelWineshop 酒店
     * @return 结果
     */
    public int updateHotelWineshop(HotelWineshop hotelWineshop);

    /**
     * 批量删除酒店
     *
     * @param hotelIds 需要删除的酒店ID
     * @return 结果
     */
    public int deleteHotelWineshopByIds(Long[] hotelIds);

    /**
     * 删除酒店信息
     *
     * @param hotelId 酒店ID
     * @return 结果
     */
    public int deleteHotelWineshopById(Long hotelId);

    /**
     * 校验酒店名是否唯一
     * @param wineshopName
     */
    String checkWineshopNameUnique(String wineshopName);
}
