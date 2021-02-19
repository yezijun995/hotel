package edu.fdzc.hotel.wineshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import edu.fdzc.hotel.common.core.domain.TreeSelect;
import edu.fdzc.hotel.common.utils.DateUtils;
import edu.fdzc.hotel.wineshop.domain.HotelRoomType;
import edu.fdzc.hotel.wineshop.mapper.HotelRoomTypeMapper;
import edu.fdzc.hotel.wineshop.service.IHotelRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 房间类型Service业务层处理
 *
 * @author yifelix
 * @date 2021-02-12
 */
@Service
public class HotelRoomTypeServiceImpl implements IHotelRoomTypeService {
    @Autowired
    private HotelRoomTypeMapper hotelRoomTypeMapper;

    /**
     * 查询房间类型
     *
     * @param roomTypeId 房间类型ID
     * @return 房间类型
     */
    @Override
    public HotelRoomType selectHotelRoomTypeById(Long roomTypeId) {
        return hotelRoomTypeMapper.selectHotelRoomTypeById(roomTypeId);
    }

    @Override
    public List<TreeSelect> buildTypeTreeSelect(List<HotelRoomType> hotelRoomTypes) {
        return hotelRoomTypes.stream().map(roomType -> {
            TreeSelect ts = new TreeSelect();
            ts.setId(roomType.getRoomTypeId());
            ts.setLabel(roomType.getTypeName());
            return ts;
        }).collect(Collectors.toList());
    }

    /**
     * 查询房间类型列表
     *
     * @param hotelRoomType 房间类型
     * @return 房间类型
     */
    @Override
    public List<HotelRoomType> selectHotelRoomTypeList(HotelRoomType hotelRoomType) {
        return hotelRoomTypeMapper.selectHotelRoomTypeList(hotelRoomType);
    }

    /**
     * 新增房间类型
     *
     * @param hotelRoomType 房间类型
     * @return 结果
     */
    @Override
    public int insertHotelRoomType(HotelRoomType hotelRoomType) {
        return hotelRoomTypeMapper.insertHotelRoomType(hotelRoomType);
    }

    /**
     * 修改房间类型
     *
     * @param hotelRoomType 房间类型
     * @return 结果
     */
    @Override
    public int updateHotelRoomType(HotelRoomType hotelRoomType) {
        return hotelRoomTypeMapper.updateHotelRoomType(hotelRoomType);
    }

    /**
     * 批量删除房间类型
     *
     * @param roomTypeIds 需要删除的房间类型ID
     * @return 结果
     */
    @Override
    public int deleteHotelRoomTypeByIds(Long[] roomTypeIds) {
        return hotelRoomTypeMapper.deleteHotelRoomTypeByIds(roomTypeIds);
    }

    /**
     * 删除房间类型信息
     *
     * @param roomTypeId 房间类型ID
     * @return 结果
     */
    @Override
    public int deleteHotelRoomTypeById(Long roomTypeId) {
        return hotelRoomTypeMapper.deleteHotelRoomTypeById(roomTypeId);
    }
}
