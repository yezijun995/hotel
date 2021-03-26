package edu.fdzc.hotel.web.controller.hotel.admin;

import edu.fdzc.hotel.common.annotation.Log;
import edu.fdzc.hotel.common.core.controller.BaseController;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.core.domain.KeyValue;
import edu.fdzc.hotel.common.core.page.TableDataInfo;
import edu.fdzc.hotel.common.enums.BusinessType;
import edu.fdzc.hotel.common.utils.poi.ExcelUtil;
import edu.fdzc.hotel.wineshop.domain.HotelRoomType;
import edu.fdzc.hotel.wineshop.service.IHotelRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 房间类型Controller
 * 
 * @author yifelix
 * @date 2021-02-12
 */
@RestController
@RequestMapping("/hotel/roomType")
public class HotelRoomTypeController extends BaseController
{
    @Autowired
    private IHotelRoomTypeService hotelRoomTypeService;

    /**
     * 查询房间类型列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:roomType:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelRoomType hotelRoomType)
    {
        startPage();
        List<HotelRoomType> list = hotelRoomTypeService.selectHotelRoomTypeList(hotelRoomType);
        return getDataTable(list);
    }

    /**
     * 导出房间类型列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:roomType:export')")
    @Log(title = "房间类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelRoomType hotelRoomType)
    {
        List<HotelRoomType> list = hotelRoomTypeService.selectHotelRoomTypeList(hotelRoomType);
        ExcelUtil<HotelRoomType> util = new ExcelUtil<HotelRoomType>(HotelRoomType.class);
        return util.exportExcel(list, "roomType");
    }

    /**
     * 获取房间类型下拉树列表
     * @param hotelRoomType
     * @return
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(HotelRoomType hotelRoomType){
        List<HotelRoomType> hotelRoomTypes = hotelRoomTypeService.selectHotelRoomTypeList(hotelRoomType);
        return AjaxResult.success(hotelRoomTypeService.buildTypeTreeSelect(hotelRoomTypes));
    }

    /**
     * 获取房间类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:roomType:query')")
    @GetMapping(value = "/{roomTypeId}")
    public AjaxResult getInfo(@PathVariable("roomTypeId") Long roomTypeId)
    {
        return AjaxResult.success(hotelRoomTypeService.selectHotelRoomTypeById(roomTypeId));
    }

    /**
     * 新增房间类型
     */
    @PreAuthorize("@ss.hasPermi('hotel:roomType:add')")
    @Log(title = "房间类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelRoomType hotelRoomType)
    {
        return toAjax(hotelRoomTypeService.insertHotelRoomType(hotelRoomType));
    }

    /**
     * 修改房间类型
     */
    @PreAuthorize("@ss.hasPermi('hotel:roomType:edit')")
    @Log(title = "房间类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelRoomType hotelRoomType)
    {
        return toAjax(hotelRoomTypeService.updateHotelRoomType(hotelRoomType));
    }

    /**
     * 删除房间类型
     */
    @PreAuthorize("@ss.hasPermi('hotel:roomType:remove')")
    @Log(title = "房间类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roomTypeIds}")
    public AjaxResult remove(@PathVariable Long[] roomTypeIds)
    {
        return toAjax(hotelRoomTypeService.deleteHotelRoomTypeByIds(roomTypeIds));
    }

    @GetMapping("/pieChart")
    public AjaxResult getPieChartRoomType(){
        List<KeyValue> keyValueList = hotelRoomTypeService.getPieChartRoomType();
        return AjaxResult.success(keyValueList);
    }
}
