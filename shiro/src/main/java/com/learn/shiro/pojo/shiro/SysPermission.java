package com.learn.shiro.pojo.shiro;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午5:08
 * 这个许可，把资源整合到一块了
 */
public class SysPermission {

    private Long id;

    /**
     * 许可名
     */
    private String name;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 资源url
     */
    private String url;

    /**
     * 许可字符串
     */
    private String desc;

    /**
     * 父编号
     */
    private Long parentId;

    private String parentIds;

    private Boolean isAvailable = Boolean.FALSE;

    /**
     * 一个许可也可以对应多个角色
     */
    private List<SysRole> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
