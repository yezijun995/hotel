package edu.fdzc.hotel.web.controller.system;

import edu.fdzc.hotel.common.annotation.Log;
import edu.fdzc.hotel.common.constant.Constants;
import edu.fdzc.hotel.common.constant.UserConstants;
import edu.fdzc.hotel.common.core.controller.BaseController;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.core.domain.entity.SysAccount;
import edu.fdzc.hotel.common.core.domain.entity.SysUser;
import edu.fdzc.hotel.common.enums.BusinessType;
import edu.fdzc.hotel.common.utils.SecurityUtils;
import edu.fdzc.hotel.common.utils.bean.BeanUtils;
import edu.fdzc.hotel.common.utils.poi.ExcelUtil;
import edu.fdzc.hotel.system.service.ISysAccountService;
import edu.fdzc.hotel.system.service.ISysUserService;
import edu.fdzc.hotel.wineshop.domain.vo.AccountInfoVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author yezj
 * @date 2021/3/14 22:27
 */
@RestController
@RequestMapping("/api/system/account")
public class AccountController extends BaseController {

    @Resource
    private ISysAccountService sysAccountService;

    @Resource
    private ISysUserService userService;

    /**
     * 新增客户
     */
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysAccount account) {
        if (UserConstants.NOT_UNIQUE.equals(sysAccountService.checkAccountNameUnique(account.getAccountName()))) {
            return AjaxResult.error("新增用户'" + account.getAccountName() + "'失败，登录账号已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(sysAccountService.checkPhoneUnique(account))) {
            return AjaxResult.error("新增用户'" + account.getAccountName() + "'失败，手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(sysAccountService.checkEmailUnique(account))) {
            return AjaxResult.error("新增用户'" + account.getAccountName() + "'失败，邮箱账号已存在");
        }
        account.setPassword(SecurityUtils.encryptPassword(account.getPassword()));
        return toAjax(sysAccountService.insertSysAccount(account));
    }

    /**
     * 导出客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:account:export')")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysAccount sysAccount) {
        List<SysAccount> list = sysAccountService.selectSysAccountList(sysAccount);
        ExcelUtil<SysAccount> util = new ExcelUtil<SysAccount>(SysAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 删除客户
     */
    @PreAuthorize("@ss.hasPermi('system:account:remove')")
    @Log(title = "客户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{accountIds}")
    public AjaxResult remove(@PathVariable Long[] accountIds) {
        return toAjax(sysAccountService.deleteSysAccountByIds(accountIds));
    }

    @GetMapping(value = "/{username}")
    public AjaxResult getAccountInfo(@PathVariable("username") String username) {
        SysAccount sysAccount = sysAccountService.selectAccountByAccountName(username);
        if (Objects.nonNull(sysAccount)) {
            return AjaxResult.success(sysAccount);
        } else {
            SysUser sysUser = userService.selectUserByUserName(username);
            return AjaxResult.success(sysUser);
        }
    }

    @PutMapping
    public AjaxResult edit(@Validated @RequestBody AccountInfoVO accountInfoVO) {
        if(Constants.ACCOUNT_TYPE.equals(accountInfoVO.getUserType())){
            SysAccount account = BeanUtils.convertObject(accountInfoVO, SysAccount.class);
            account.setAccountId(accountInfoVO.getUserId());
            account.setAccountName(accountInfoVO.getUserName());
            return AjaxResult.success(sysAccountService.updateSysAccount(account));
        }
        SysUser user = BeanUtils.convertObject(accountInfoVO, SysUser.class);
        user.setPhonenumber(accountInfoVO.getPhone());
        return AjaxResult.success(userService.updateUser(user));
    }

}
