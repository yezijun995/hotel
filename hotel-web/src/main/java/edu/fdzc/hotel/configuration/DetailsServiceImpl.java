package edu.fdzc.hotel.configuration;

import edu.fdzc.hotel.constant.CommonConstant;
import edu.fdzc.hotel.po.Role;
import edu.fdzc.hotel.po.User;
import edu.fdzc.hotel.service.IRoleService;
import edu.fdzc.hotel.service.IUserService;
import edu.fdzc.hotel.service.IWorkerService;
import edu.fdzc.hotel.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yezj
 * @date 2021/2/10 20:52
 */
@Component("detailsServiceImpl")
@Slf4j
public class DetailsServiceImpl implements UserDetailsService {

    @Resource
    private IUserService userService;

    @Resource
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户不能为空");
        }
        User user = userService.loadUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Role> roles = userService.getUserRoleById(user.getId());
        roles.forEach(role -> {
            //声明用户授权
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleType());
            grantedAuthorities.add(grantedAuthority);
        });
        user.setRoles(roles);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Objects.equals(CommonConstant.UN_DELETED, user.getDeleted()), Boolean.TRUE,
                Boolean.TRUE, Boolean.TRUE, grantedAuthorities);
    }
}
