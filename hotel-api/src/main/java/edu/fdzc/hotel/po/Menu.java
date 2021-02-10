package edu.fdzc.hotel.po;

import java.util.Date;
import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author yezj
 * @since 2021-02-10 16:41:31
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -44366412747171943L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 请求地址
     */
    private String url;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 上级菜单ID
     */
    private Long parentId;
    /**
     * 菜单排序
     */
    private Integer menuSort;
    /**
     * 菜单类型
     */
    private Integer menuType;
    /**
     * 管理员角色
     */
    private Byte adminRole;
    /**
     * 酒店ID
     */
    private Long hotelId;
    /**
     * 创建人
     */
    private Long createor;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Long updater;
    /**
     * 更新时间
     */
    private Date updateTime;

    private String state;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否删除
     */
    private Byte deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Byte getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Byte adminRole) {
        this.adminRole = adminRole;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getCreateor() {
        return createor;
    }

    public void setCreateor(Long createor) {
        this.createor = createor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
