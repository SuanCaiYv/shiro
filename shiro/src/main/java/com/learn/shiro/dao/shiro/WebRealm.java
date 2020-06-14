package com.learn.shiro.dao.shiro;

import com.learn.shiro.pojo.shiro.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午11:22
 */
@Component
public class WebRealm extends AuthorizingRealm {

    private static final HashedCredentialsMatcher credentialsMatcher;

    private final SysUserMapper sysUserMapper;

    private final SysUserRolesMapper sysUserRolesMapper;

    private final SysUserPermissionsMapper sysUserPermissionsMapper;

    private final SysRoleMapper sysRoleMapper;

    private final SysPermissionMapper sysPermissionMapper;

    private final SysRolePermissionsMapper sysRolePermissionsMapper;

    static {
        credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
    }

    public WebRealm(@Autowired SysUserMapper sysUserMapper, @Autowired SysUserRolesMapper sysUserRolesMapper,
                    @Autowired SysUserPermissionsMapper sysUserPermissionsMapper, @Autowired SysRoleMapper sysRoleMapper,
                    @Autowired SysPermissionMapper sysPermissionMapper, @Autowired SysRolePermissionsMapper sysRolePermissionsMapper) {
        this.setCredentialsMatcher(credentialsMatcher);
        this.sysUserMapper = sysUserMapper;
        this.sysUserRolesMapper = sysUserRolesMapper;
        this.sysUserPermissionsMapper = sysUserPermissionsMapper;
        this.sysRoleMapper = sysRoleMapper;
        this.sysPermissionMapper = sysPermissionMapper;
        this.sysRolePermissionsMapper = sysRolePermissionsMapper;
    }


    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SysUser sysUser = sysUserMapper.select(username);
        List<Long> roleIds = sysUserRolesMapper.selectByUser(sysUser.getId());
        List<Long> permissionIds = sysUserPermissionsMapper.selectByUser(sysUser.getId());
        Set<String> roles = new HashSet<>();
        Set<Permission> permissions = new HashSet<>();
        for (Long roleId : roleIds) {
            roles.add(sysRoleMapper.selectById(roleId).getName());
            for (Long permissionId : permissionIds) {
                WildcardPermission permission = new WildcardPermission(sysRoleMapper.selectById(roleId).getName()+
                        ":"+sysPermissionMapper.selectById(permissionId).getName());
                permissions.add(permission);
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setObjectPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        SysUser sysUser = sysUserMapper.select(username);
        if (sysUser == null) {
            throw new UnknownAccountException("Unsigned User!");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(), sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()), this.getName());
        return simpleAuthenticationInfo;
    }
}
