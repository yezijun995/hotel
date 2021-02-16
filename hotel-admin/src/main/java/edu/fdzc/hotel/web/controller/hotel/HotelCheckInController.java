package edu.fdzc.hotel.web.controller.hotel;

import java.util.List;

import edu.fdzc.hotel.wineshop.domain.HotelCheckIn;
import edu.fdzc.hotel.wineshop.service.IHotelCheckInService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.fdzc.hotel.common.annotation.Log;
import edu.fdzc.hotel.common.core.controller.BaseController;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.enums.BusinessType;
import edu.fdzc.hotel.common.utils.poi.ExcelUtil;
import edu.fdzc.hotel.common.core.page.TableDataInfo;

/**
 * 入住退房登记管理Controller
 * 
 * @author yifelix
 * @date 2021-02-16
 */
@RestController
@RequestMapping("/hotel/checkIn")
public class HotelCheckInController extends BaseController
{
    @Autowired
    private IHotelCheckInService hotelCheckInService;

    /**
     * 查询入住退房登记管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkIn:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelCheckIn hotelCheckIn)
    {
        startPage();
        List<HotelCheckIn> list = hotelCheckInService.selectHotelCheckInList(hotelCheckIn);
        return getDataTable(list);
    }

    /**
     * 导出入住退房登记管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkIn:export')")
    @Log(title = "入住退房登记管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelCheckIn hotelCheckIn)
    {
        List<HotelCheckIn> list = hotelCheckInService.selectHotelCheckInList(hotelCheckIn);
        ExcelUtil<HotelCheckIn> util = new ExcelUtil<HotelCheckIn>(HotelCheckIn.class);
        return util.exportExcel(list, "checkIn");
    }

    /**
     * 获取入住退房登记管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkIn:query')")
    @GetMapping(value = "/{checkInId}")
    public AjaxResult getInfo(@PathVariable("checkInId") Long checkInId)
    {
        return AjaxResult.success(hotelCheckInService.selectHotelCheckInById(checkInId));
    }

    /**
     * 新增入住退房登记管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkIn:add')")
    @Log(title = "入住退房登记管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelCheckIn hotelCheckIn)
    {
        return toAjax(hotelCheckInService.insertHotelCheckIn(hotelCheckIn));
    }

    /**
     * 修改入住退房登记管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkIn:edit')")
    @Log(title = "入住退房登记管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelCheckIn hotelCheckIn)
    {
        return toAjax(hotelCheckInService.updateHotelCheckIn(hotelCheckIn));
    }

    /**
     * 删除入住退房登记管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkIn:remove')")
    @Log(title = "入住退房登记管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{checkInIds}")
    public AjaxResult remove(@PathVariable Long[] checkInIds)
    {
        return toAjax(hotelCheckInService.deleteHotelCheckInByIds(checkInIds));
    }
}
