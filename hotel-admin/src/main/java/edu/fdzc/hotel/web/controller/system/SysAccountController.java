package edu.fdzc.hotel.web.controller.system;

import edu.fdzc.hotel.common.annotation.Log;
import edu.fdzc.hotel.common.constant.UserConstants;
import edu.fdzc.hotel.common.core.controller.BaseController;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.core.domain.entity.SysAccount;
import edu.fdzc.hotel.common.core.domain.entity.SysUser;
import edu.fdzc.hotel.common.enums.BusinessType;
import edu.fdzc.hotel.common.utils.SecurityUtils;
import edu.fdzc.hotel.system.service.ISysAccountService;
import edu.fdzc.hotel.system.service.ISysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author yezj
 * @date 2021/3/14 22:27
 */
@RestController
@RequestMapping("/api/system/account")
public class SysAccountController extends BaseController {

    @Resource
    private ISysAccountService accountService;

    @Resource
    private ISysUserService userService;

    /**
     * 新增客户
     */
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysAccount account) {
        if (UserConstants.NOT_UNIQUE.equals(accountService.checkAccountNameUnique(account.getAccountName()))) {
            return AjaxResult.error("新增用户'" + account.getAccountName() + "'失败，登录账号已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(accountService.checkPhoneUnique(account))) {
            return AjaxResult.error("新增用户'" + account.getAccountName() + "'失败，手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(accountService.checkEmailUnique(account))) {
            return AjaxResult.error("新增用户'" + account.getAccountName() + "'失败，邮箱账号已存在");
        }
        account.setPassword(SecurityUtils.encryptPassword(account.getPassword()));
        return toAjax(accountService.insertSysAccount(account));
    }

    @GetMapping(value = "/{username}")
    public AjaxResult getAccountInfo(@PathVariable("username") String username) {
        SysAccount sysAccount = accountService.selectAccountByAccountName(username);
        if (Objects.nonNull(sysAccount)) {
            return AjaxResult.success(sysAccount);
        } else {
            SysUser sysUser = userService.selectUserByUserName(username);
            return AjaxResult.success(sysUser);
        }
    }
}
