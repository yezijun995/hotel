package edu.fdzc.hotel.wineshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import edu.fdzc.hotel.common.constant.UserConstants;
import edu.fdzc.hotel.common.core.domain.TreeSelect;
import edu.fdzc.hotel.common.core.domain.entity.SysDept;
import edu.fdzc.hotel.common.utils.DateUtils;
import edu.fdzc.hotel.wineshop.mapper.HotelWineshopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fdzc.hotel.wineshop.domain.HotelWineshop;
import edu.fdzc.hotel.wineshop.service.IHotelWineshopService;
import sun.management.HotspotClassLoadingMBean;

/**
 * 酒店Service业务层处理
 *
 * @author yifelix
 * @date 2021-02-12
 */
@Service
public class HotelWineshopServiceImpl implements IHotelWineshopService {
    @Autowired
    private HotelWineshopMapper hotelWineshopMapper;

    /**
     * 查询酒店
     *
     * @param hotelId 酒店ID
     * @return 酒店
     */
    @Override
    public HotelWineshop selectHotelWineshopById(Long hotelId) {
        return hotelWineshopMapper.selectHotelWineshopById(hotelId);
    }

    @Override
    public void checkRoleAllowed(HotelWineshop hotelWineshop) {
    }

    @Override
    public int updateWineshopStatus(HotelWineshop hotelWineshop) {
        return hotelWineshopMapper.updateHotelWineshop(hotelWineshop);
    }

    /**
     * 查询酒店列表
     *
     * @param hotelWineshop 酒店
     * @return 酒店
     */
    @Override
    public List<HotelWineshop> selectHotelWineshopList(HotelWineshop hotelWineshop) {
        return hotelWineshopMapper.selectHotelWineshopList(hotelWineshop);
    }

    /**
     * 新增酒店
     *
     * @param hotelWineshop 酒店
     * @return 结果
     */
    @Override
    public int insertHotelWineshop(HotelWineshop hotelWineshop) {
        return hotelWineshopMapper.insertHotelWineshop(hotelWineshop);
    }

    @Override
    public List<TreeSelect> buildWineshopTreeSelect(List<HotelWineshop> wineshops) {
        return wineshops.stream().map(wineshop -> {
            TreeSelect ts = new TreeSelect();
            ts.setId(wineshop.getHotelId());
            ts.setLabel(wineshop.getName());
            return ts;
        }).collect(Collectors.toList());
    }

    /**
     * 修改酒店
     *
     * @param hotelWineshop 酒店
     * @return 结果
     */
    @Override
    public int updateHotelWineshop(HotelWineshop hotelWineshop) {
        return hotelWineshopMapper.updateHotelWineshop(hotelWineshop);
    }

    /**
     * 批量删除酒店
     *
     * @param hotelIds 需要删除的酒店ID
     * @return 结果
     */
    @Override
    public int deleteHotelWineshopByIds(Long[] hotelIds) {
        return hotelWineshopMapper.deleteHotelWineshopByIds(hotelIds);
    }

    /**
     * 删除酒店信息
     *
     * @param hotelId 酒店ID
     * @return 结果
     */
    @Override
    public int deleteHotelWineshopById(Long hotelId) {
        return hotelWineshopMapper.deleteHotelWineshopById(hotelId);
    }

    @Override
    public String checkWineshopNameUnique(String wineshopName) {
        int count = hotelWineshopMapper.checkWineshopNameUnique(wineshopName);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
