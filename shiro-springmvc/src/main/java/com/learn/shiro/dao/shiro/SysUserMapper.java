package com.learn.shiro.dao.shiro;

import com.learn.shiro.pojo.shiro.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午5:34
 */
@Mapper
@Component("sysUserMapper")
public interface SysUserMapper {

    void insert(SysUser userInfo);

    void update(SysUser userInfo);

    void deleteByName(String name);

    void delete(SysUser userInfo);

    SysUser select(String name);
}
