package com.learn.shiro.pojo.shiro;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午5:00
 */
public class SysUser {

    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private Integer state;

    /**
     * 一个用户可以拥有多个角色
     */
    private List<SysRole> roles;

    /**
     * 一个用户可以拥有多个许可
     */
    private List<SysPermission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
