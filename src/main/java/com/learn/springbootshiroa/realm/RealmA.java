package com.learn.springbootshiroa.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author SuanCaiYv
 * @time 2020/4/23 下午3:23
 */
public class RealmA extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println(token.getUsername()+" : "+new String(token.getPassword()) + " : " + token.getPrincipal());
        if (!"2508826394@qq.com".equals(token.getUsername())) {
            throw new UnknownAccountException("账户不存在");
        }
        else if (!"461200".equals(new String(token.getPassword()))) {
            throw new IncorrectCredentialsException("密码错误");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());
    }
}
