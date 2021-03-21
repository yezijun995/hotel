package edu.fdzc.hotel.web.controller.hotel.admin;

import java.util.List;

import edu.fdzc.hotel.wineshop.domain.HotelMessage;
import edu.fdzc.hotel.wineshop.service.IHotelMessageService;
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
 * 留言管理Controller
 * 
 * @author yifelix
 * @date 2021-02-16
 */
@RestController
@RequestMapping("/hotel/message")
public class HotelMessageController extends BaseController
{
    @Autowired
    private IHotelMessageService hotelMessageService;

    /**
     * 查询留言管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelMessage hotelMessage)
    {
        startPage();
        List<HotelMessage> list = hotelMessageService.selectHotelMessageList(hotelMessage);
        return getDataTable(list);
    }

    /**
     * 导出留言管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:message:export')")
    @Log(title = "留言管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelMessage hotelMessage)
    {
        List<HotelMessage> list = hotelMessageService.selectHotelMessageList(hotelMessage);
        ExcelUtil<HotelMessage> util = new ExcelUtil<HotelMessage>(HotelMessage.class);
        return util.exportExcel(list, "message");
    }

    /**
     * 获取留言管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:message:query')")
    @GetMapping(value = "/{messageId}")
    public AjaxResult getInfo(@PathVariable("messageId") Long messageId)
    {
        return AjaxResult.success(hotelMessageService.selectHotelMessageById(messageId));
    }

    /**
     * 新增留言管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:message:add')")
    @Log(title = "留言管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelMessage hotelMessage)
    {
        return toAjax(hotelMessageService.insertHotelMessage(hotelMessage));
    }

    /**
     * 修改留言管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:message:edit')")
    @Log(title = "留言管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelMessage hotelMessage)
    {
        return toAjax(hotelMessageService.updateHotelMessage(hotelMessage));
    }

    /**
     * 删除留言管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:message:remove')")
    @Log(title = "留言管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{messageIds}")
    public AjaxResult remove(@PathVariable Long[] messageIds)
    {
        return toAjax(hotelMessageService.deleteHotelMessageByIds(messageIds));
    }
}
