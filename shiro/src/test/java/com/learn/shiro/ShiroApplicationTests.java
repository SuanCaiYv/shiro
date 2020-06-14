package com.learn.shiro;

import com.learn.shiro.dao.shiro.SysPermissionMapper;
import com.learn.shiro.dao.shiro.SysRoleMapper;
import com.learn.shiro.dao.shiro.SysUserMapper;
import com.learn.shiro.pojo.shiro.SysPermission;
import com.learn.shiro.pojo.shiro.SysUser;
import com.learn.shiro.util.BaseUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Test
    void contextLoads() {

//        SysUser sysUser = new SysUser();
//        sysUser.setUsername("2021601470@qq.com");
//        sysUser.setNickname("水煮鱼");
//        sysUser.setState(0);
//        String salt = BaseUtil.getSalt();
//        sysUser.setSalt(salt);
//        SimpleHash simpleHash = new SimpleHash("MD5", "123456", salt, 1024);
//        sysUser.setPassword(simpleHash.toHex());
//        sysUserMapper.insert(sysUser);
    }
}
