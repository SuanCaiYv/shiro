package com.learn.shiro.dao.shiro;

import com.learn.shiro.pojo.shiro.SysUserPermissions;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/6/11 下午2:38
 */
@Mapper
@Component("sysUserPermissionsMapper")
public interface SysUserPermissionsMapper {

    void insert(SysUserPermissions sysUserPermissions);

    void delete(SysUserPermissions sysUserPermissions);

    void deleteByUser(Long userId);

    void update(SysUserPermissions sysUserPermissions);

    SysUserPermissions select(SysUserPermissions sysUserPermissions);

    List<Long> selectByUser(Long id);
}
