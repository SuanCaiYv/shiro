package com.learn.shiro.dao.shiro;

import com.learn.shiro.pojo.shiro.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午5:41
 */
@Mapper
@Component
public interface SysRoleMapper {

    void insert(SysRole role);

    void delete(SysRole role);

    void deleteByName(String name);

    void update(SysRole role);

    SysRole select(String name);

    SysRole selectById(Long id);
}
