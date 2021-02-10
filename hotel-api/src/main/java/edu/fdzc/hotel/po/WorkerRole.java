package edu.fdzc.hotel.po;

import java.io.Serializable;

/**
 * (WorkerRole)实体类
 *
 * @author makejava
 * @since 2021-02-10 16:41:36
 */
public class WorkerRole implements Serializable {
    private static final long serialVersionUID = -45277105742897206L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 员工ID
     */
    private Long workerId;
    /**
     * 角色ID
     */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
