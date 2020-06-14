package com.learn.shiro.dao.shiro;

import com.learn.shiro.pojo.shiro.SysRolePermissions;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/6/11 下午2:39
 */
@Mapper
@Component("sysRolePermissionsMapper")
public interface SysRolePermissionsMapper {

    void insert(SysRolePermissions sysRolePermissions);

    void delete(SysRolePermissions sysRolePermissions);

    void deleteByRole(Long roleId);

    void update(SysRolePermissions sysRolePermissions);

    SysRolePermissions select(SysRolePermissions sysRolePermissions);

    List<Long> selectByRole(Long roleId);
}
