package com.learn.shiro.pojo.shiro;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午5:07
 */
public class SysRole {

    private Long id;

    /**
     * 角色名
     */
    private String name;

    private String desc;

    private Boolean isAvailable = Boolean.FALSE;

    /**
     * 一个角色可以拥有多个许可
     */
    private List<SysPermission> permissions;

    /**
     * 一个角色也可以对应多个用户
     */
    private List<SysUser> userInfos;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<SysUser> userInfos) {
        this.userInfos = userInfos;
    }
}
