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
@Component("webRealm")
public class WebRealm extends AuthorizingRealm {

    private static final HashedCredentialsMatcher credentialsMatcher;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRolesMapper sysUserRolesMapper;

    @Autowired
    private SysUserPermissionsMapper sysUserPermissionsMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionsMapper sysRolePermissionsMapper;

    static {
        credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
    }

    public WebRealm() {
        this.setCredentialsMatcher(credentialsMatcher);
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
        System.out.println("authza");
        return simpleAuthorizationInfo;
    }

    /**
     * 验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        System.out.println(username);
        SysUser sysUser = sysUserMapper.select(username);
        if (sysUser == null) {
            throw new UnknownAccountException("Unsigned User!");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(), sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()), this.getName());
        return simpleAuthenticationInfo;
    }
}
