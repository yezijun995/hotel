package edu.fdzc.hotel.web.controller.hotel;

import java.util.List;

import edu.fdzc.hotel.common.constant.UserConstants;
import edu.fdzc.hotel.common.core.domain.entity.SysRole;
import edu.fdzc.hotel.common.utils.SecurityUtils;
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
import edu.fdzc.hotel.wineshop.domain.HotelWineshop;
import edu.fdzc.hotel.wineshop.service.IHotelWineshopService;
import edu.fdzc.hotel.common.utils.poi.ExcelUtil;
import edu.fdzc.hotel.common.core.page.TableDataInfo;

/**
 * 酒店Controller
 *
 * @author yifelix
 * @date 2021-02-12
 */
@RestController
@RequestMapping("/hotel/wineshop")
public class HotelWineshopController extends BaseController {
    @Autowired
    private IHotelWineshopService hotelWineshopService;

    /**
     * 查询酒店列表
     */
    @PreAuthorize("@ss.hasPermi('wineshop:wineshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelWineshop hotelWineshop) {
        startPage();
        List<HotelWineshop> list = hotelWineshopService.selectHotelWineshopList(hotelWineshop);
        return getDataTable(list);
    }

    /**
     * 获取酒店下拉树列表
     *
     * @param hotelWineshop
     * @return
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(HotelWineshop hotelWineshop) {
        List<HotelWineshop> hotelWineshops = hotelWineshopService.selectHotelWineshopList(hotelWineshop);
        return AjaxResult.success(hotelWineshopService.buildWineshopTreeSelect(hotelWineshops));
    }

    /**
     * 导出酒店列表
     */
    @PreAuthorize("@ss.hasPermi('wineshop:wineshop:export')")
    @Log(title = "酒店管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelWineshop hotelWineshop) {
        List<HotelWineshop> list = hotelWineshopService.selectHotelWineshopList(hotelWineshop);
        ExcelUtil<HotelWineshop> util = new ExcelUtil<HotelWineshop>(HotelWineshop.class);
        return util.exportExcel(list, "wineshop");
    }

    /**
     * 获取酒店详细信息
     */
    @PreAuthorize("@ss.hasPermi('wineshop:wineshop:query')")
    @GetMapping(value = "/{hotelId}")
    public AjaxResult getInfo(@PathVariable("hotelId") Long hotelId) {
        return AjaxResult.success(hotelWineshopService.selectHotelWineshopById(hotelId));
    }

    /**
     * 新增酒店
     */
    @PreAuthorize("@ss.hasPermi('wineshop:wineshop:add')")
    @Log(title = "酒店管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelWineshop hotelWineshop) {
        if (UserConstants.NOT_UNIQUE.equals(hotelWineshopService.checkWineshopNameUnique(hotelWineshop.getName()))) {
            return AjaxResult.error("新增酒店'" + hotelWineshop.getName() + "'失败，酒店已存在");
        }
        hotelWineshop.setCreateBy(SecurityUtils.getUsername());
        return toAjax(hotelWineshopService.insertHotelWineshop(hotelWineshop));
    }

    /**
     * 修改酒店
     */
    @PreAuthorize("@ss.hasPermi('wineshop:wineshop:edit')")
    @Log(title = "酒店管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelWineshop hotelWineshop) {
        if (UserConstants.NOT_UNIQUE.equals(hotelWineshopService.checkWineshopNameUnique(hotelWineshop.getName()))) {
            return AjaxResult.error("修改酒店'" + hotelWineshop.getName() + "'失败，酒店已存在");
        }
        hotelWineshop.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(hotelWineshopService.updateHotelWineshop(hotelWineshop));
    }

    /**
     * 删除酒店
     */
    @PreAuthorize("@ss.hasPermi('wineshop:wineshop:remove')")
    @Log(title = "酒店管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{hotelIds}")
    public AjaxResult remove(@PathVariable Long[] hotelIds) {
        return toAjax(hotelWineshopService.deleteHotelWineshopByIds(hotelIds));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('wineshop:wineshop:edit')")
    @Log(title = "酒店管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody HotelWineshop hotelWineshop) {
        hotelWineshopService.checkRoleAllowed(hotelWineshop);
        hotelWineshop.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(hotelWineshopService.updateWineshopStatus(hotelWineshop));
    }
}
