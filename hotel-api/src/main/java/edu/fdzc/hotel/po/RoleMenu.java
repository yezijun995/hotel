package edu.fdzc.hotel.po;

import java.io.Serializable;

/**
 * (RoleMenu)实体类
 *
 * @author makejava
 * @since 2021-02-10 16:41:32
 */
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 280008282443423546L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色ID
     */
    private Long menuId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}
