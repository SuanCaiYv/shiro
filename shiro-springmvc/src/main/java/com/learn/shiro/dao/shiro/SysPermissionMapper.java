package com.learn.shiro.dao.shiro;

import com.learn.shiro.pojo.shiro.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午5:41
 */
@Mapper
@Component("sysPermissionMapper")
public interface SysPermissionMapper {

    void insert(SysPermission permission);

    void delete(SysPermission permission);

    void deleteByName(String name);

    void update(SysPermission permission);

    SysPermission select(String name);

    SysPermission selectById(Long id);
}
