package edu.fdzc.hotel.web.controller.system.admin;

import edu.fdzc.hotel.common.annotation.Log;
import edu.fdzc.hotel.common.core.controller.BaseController;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.core.domain.entity.SysAccount;
import edu.fdzc.hotel.common.core.page.TableDataInfo;
import edu.fdzc.hotel.common.enums.BusinessType;
import edu.fdzc.hotel.common.utils.poi.ExcelUtil;
import edu.fdzc.hotel.system.service.ISysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户Controller
 *
 * @author yifelix
 * @date 2021-05-02
 */
@RestController
@RequestMapping("/system/account")
public class SysAccountController extends BaseController
{
    @Autowired
    private ISysAccountService sysAccountService;

    /**
     * 查询客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysAccount sysAccount)
    {
        startPage();
        List<SysAccount> list = sysAccountService.selectSysAccountList(sysAccount);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:account:export')")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysAccount sysAccount)
    {
        List<SysAccount> list = sysAccountService.selectSysAccountList(sysAccount);
        ExcelUtil<SysAccount> util = new ExcelUtil<SysAccount>(SysAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 获取客户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:account:query')")
    @GetMapping(value = "/{accountId}")
    public AjaxResult getInfo(@PathVariable("accountId") Long accountId)
    {
        return AjaxResult.success(sysAccountService.selectSysAccountById(accountId));
    }

    /**
     * 新增客户
     */
    @PreAuthorize("@ss.hasPermi('system:account:add')")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysAccount sysAccount)
    {
        return toAjax(sysAccountService.insertSysAccount(sysAccount));
    }

    /**
     * 修改客户
     */
    @PreAuthorize("@ss.hasPermi('system:account:edit')")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysAccount sysAccount)
    {
        return toAjax(sysAccountService.updateSysAccount(sysAccount));
    }

    /**
     * 删除客户
     */
    @PreAuthorize("@ss.hasPermi('system:account:remove')")
    @Log(title = "客户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{accountIds}")
    public AjaxResult remove(@PathVariable Long[] accountIds)
    {
        return toAjax(sysAccountService.deleteSysAccountByIds(accountIds));
    }
}
