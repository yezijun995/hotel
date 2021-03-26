package edu.fdzc.hotel.wineshop.service;

import edu.fdzc.hotel.common.core.domain.TreeSelect;
import edu.fdzc.hotel.wineshop.domain.HotelRoomType;

import edu.fdzc.hotel.common.core.domain.KeyValue;
import java.util.List;

/**
 * 房间类型Service接口
 *
 * @author yifelix
 * @date 2021-02-12
 */
public interface IHotelRoomTypeService {
    /**
     * 查询房间类型
     *
     * @param roomTypeId 房间类型ID
     * @return 房间类型
     */
    public HotelRoomType selectHotelRoomTypeById(Long roomTypeId);

    /**
     * 查询房间类型列表
     *
     * @param hotelRoomType 房间类型
     * @return 房间类型集合
     */
    public List<HotelRoomType> selectHotelRoomTypeList(HotelRoomType hotelRoomType);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param hotelRoomTypes
     * @return
     */
    List<TreeSelect> buildTypeTreeSelect(List<HotelRoomType> hotelRoomTypes);

    /**
     * 新增房间类型
     *
     * @param hotelRoomType 房间类型
     * @return 结果
     */
    public int insertHotelRoomType(HotelRoomType hotelRoomType);

    /**
     * 修改房间类型
     *
     * @param hotelRoomType 房间类型
     * @return 结果
     */
    public int updateHotelRoomType(HotelRoomType hotelRoomType);

    /**
     * 批量删除房间类型
     *
     * @param roomTypeIds 需要删除的房间类型ID
     * @return 结果
     */
    public int deleteHotelRoomTypeByIds(Long[] roomTypeIds);

    /**
     * 删除房间类型信息
     *
     * @param roomTypeId 房间类型ID
     * @return 结果
     */
    public int deleteHotelRoomTypeById(Long roomTypeId);

    /**
     * 获取酒店下所有可预订房间类型
     * @param hotelId
     * @return
     */
    List<HotelRoomType> getBookableRoomTypeByHotelId(Long hotelId);

    List<KeyValue> getPieChartRoomType();
}
