package edu.fdzc.hotel.web.controller.hotel.admin;

import edu.fdzc.hotel.common.annotation.Log;
import edu.fdzc.hotel.common.core.controller.BaseController;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.core.page.TableDataInfo;
import edu.fdzc.hotel.common.enums.BusinessType;
import edu.fdzc.hotel.common.utils.poi.ExcelUtil;
import edu.fdzc.hotel.wineshop.domain.HotelOrders;
import edu.fdzc.hotel.wineshop.service.IHotelOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 * 
 * @author yifelix
 * @date 2021-02-16
 */
@RestController
@RequestMapping("/hotel/orders")
public class HotelOrdersController extends BaseController
{
    @Autowired
    private IHotelOrdersService hotelOrdersService;

    /**
     * 查询订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:orders:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelOrders hotelOrders)
    {
        startPage();
        List<HotelOrders> list = hotelOrdersService.selectHotelOrdersList(hotelOrders);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:orders:export')")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelOrders hotelOrders)
    {
        List<HotelOrders> list = hotelOrdersService.selectHotelOrdersList(hotelOrders);
        ExcelUtil<HotelOrders> util = new ExcelUtil<HotelOrders>(HotelOrders.class);
        return util.exportExcel(list, "orders");
    }

    /**
     * 获取订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:orders:query')")
    @GetMapping(value = "/{ordersId}")
    public AjaxResult getInfo(@PathVariable("ordersId") Long ordersId)
    {
        return AjaxResult.success(hotelOrdersService.selectHotelOrdersById(ordersId));
    }

    /**
     * 新增订单管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:orders:add')")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelOrders hotelOrders)
    {
        return toAjax(hotelOrdersService.insertHotelOrders(hotelOrders));
    }

    /**
     * 修改订单管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:orders:edit')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelOrders hotelOrders)
    {
        return toAjax(hotelOrdersService.updateHotelOrders(hotelOrders));
    }

    /**
     * 删除订单管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:orders:remove')")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ordersIds}")
    public AjaxResult remove(@PathVariable Long[] ordersIds)
    {
        return toAjax(hotelOrdersService.deleteHotelOrdersByIds(ordersIds));
    }
}
