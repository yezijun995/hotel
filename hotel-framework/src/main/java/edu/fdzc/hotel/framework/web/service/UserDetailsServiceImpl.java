package edu.fdzc.hotel.framework.web.service;

import edu.fdzc.hotel.common.core.domain.entity.SysAccount;
import edu.fdzc.hotel.common.core.domain.entity.SysUser;
import edu.fdzc.hotel.common.core.domain.model.LoginUser;
import edu.fdzc.hotel.common.enums.UserStatus;
import edu.fdzc.hotel.common.exception.BaseException;
import edu.fdzc.hotel.common.utils.StringUtils;
import edu.fdzc.hotel.common.utils.bean.BeanUtils;
import edu.fdzc.hotel.system.service.ISysAccountService;
import edu.fdzc.hotel.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户验证处理
 *
 * @author yifelix
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysPermissionService permissionService;

    @Resource
    private ISysAccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.selectUserByUserName(username);

        SysAccount sysAccount = accountService.selectAccountByAccountName(username);
        if (Objects.nonNull(user)) {
            if (Objects.isNull(user)) {
                log.info("登录用户：{} 不存在.", username);
                throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
            } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
                log.info("登录用户：{} 已被删除.", username);
                throw new BaseException("对不起，您的账号：" + username + " 已被删除");
            } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
                log.info("登录用户：{} 已被停用.", username);
                throw new BaseException("对不起，您的账号：" + username + " 已停用");
            }
            return createLoginUser(user);
        } else if (Objects.nonNull(sysAccount)) {
            if (UserStatus.DELETED.getCode().equals(sysAccount.getDelFlag())) {
                log.info("登录客户：{} 已被删除.", username);
                throw new BaseException("对不起，您的账号：" + username + " 已被删除");
            } else if (UserStatus.DISABLE.getCode().equals(sysAccount.getStatus())) {
                log.info("登录客户：{} 已被停用.", username);
                throw new BaseException("对不起，您的账号：" + username + " 已停用");
            }
            SysUser sysUser = BeanUtils.convertObject(sysAccount, SysUser.class);
            sysUser.setUserName(sysAccount.getAccountName());
            sysUser.setPassword(sysAccount.getPassword());
            Set<String> set = new HashSet<>();
            set.add("common");
            return new LoginUser(sysUser, set);
        }
        log.info("登录用户：{} 不存在.", username);
        throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
    }

    public UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user, permissionService.getMenuPermission(user));
    }

}
