package com.learn.shiro.dao.shiro;

import com.learn.shiro.pojo.shiro.SysUserRoles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/6/11 下午2:37
 */
@Mapper
@Component
public interface SysUserRolesMapper {

    void insert(SysUserRoles sysUserRoles);

    void delete(SysUserRoles sysUserRoles);

    void deleteByUser(Long userId);

    void update(SysUserRoles sysUserRoles);

    SysUserRoles select(SysUserRoles sysUserRoles);

    List<Long> selectByUser(Long userId);
}
