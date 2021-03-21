package edu.fdzc.hotel.web.controller.hotel.admin;

import edu.fdzc.hotel.common.annotation.Log;
import edu.fdzc.hotel.common.constant.UserConstants;
import edu.fdzc.hotel.common.core.controller.BaseController;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.core.page.TableDataInfo;
import edu.fdzc.hotel.common.enums.BusinessType;
import edu.fdzc.hotel.common.utils.SecurityUtils;
import edu.fdzc.hotel.common.utils.poi.ExcelUtil;
import edu.fdzc.hotel.wineshop.domain.HotelRoom;
import edu.fdzc.hotel.wineshop.service.IHotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 房间管理Controller
 *
 * @author yifelix
 * @date 2021-02-13
 */
@RestController
@RequestMapping("/hotel/room")
public class HotelRoomController extends BaseController {
    @Autowired
    private IHotelRoomService hotelRoomService;

    /**
     * 查询房间管理列表
     */
    @PreAuthorize("@ss.hasPermi('room:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelRoom hotelRoom) {
        startPage();
        List<HotelRoom> list = hotelRoomService.selectHotelRoomList(hotelRoom);
        return getDataTable(list);
    }

    /**
     * 导出房间管理列表
     */
    @PreAuthorize("@ss.hasPermi('room:room:export')")
    @Log(title = "房间管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelRoom hotelRoom) {
        List<HotelRoom> list = hotelRoomService.selectHotelRoomList(hotelRoom);
        ExcelUtil<HotelRoom> util = new ExcelUtil<HotelRoom>(HotelRoom.class);
        return util.exportExcel(list, "room");
    }

    /**
     * 获取房间管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('room:room:query')")
    @GetMapping(value = "/{roomId}")
    public AjaxResult getInfo(@PathVariable("roomId") Long roomId) {
        return AjaxResult.success(hotelRoomService.selectHotelRoomById(roomId));
    }

    /**
     * 新增房间管理
     */
    @PreAuthorize("@ss.hasPermi('room:room:add')")
    @Log(title = "房间管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelRoom hotelRoom) {
        if (UserConstants.NOT_UNIQUE.equals(hotelRoomService.checkRoomNameUnique(hotelRoom.getHotelId(), hotelRoom.getNumber()))) {
            return AjaxResult.error("新增房间'" + hotelRoom.getNumber() + "'失败，此酒店的房间已存在");
        }
        hotelRoom.setCreateBy(SecurityUtils.getUsername());
        return toAjax(hotelRoomService.insertHotelRoom(hotelRoom));
    }

    /**
     * 修改房间管理
     */
    @PreAuthorize("@ss.hasPermi('room:room:edit')")
    @Log(title = "房间管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelRoom hotelRoom) {
        hotelRoom.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(hotelRoomService.updateHotelRoom(hotelRoom));
    }

    /**
     * 删除房间管理
     */
    @PreAuthorize("@ss.hasPermi('room:room:remove')")
    @Log(title = "房间管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{roomIds}")
    public AjaxResult remove(@PathVariable Long[] roomIds) {
        return toAjax(hotelRoomService.deleteHotelRoomByIds(roomIds));
    }
}
