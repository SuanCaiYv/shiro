package com.learn.shiro.pojo.shiro;

/**
 * @author SuanCaiYv
 * @time 2020/6/11 下午2:33
 */
public class SysUserPermissions {

    private Long id;

    private Long userId;

    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
