package com.learn.shiro.controller;

import com.learn.shiro.result.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午8:43
 */
@RestController
public class ControllerTwo {

//    @RequiresAuthentication
//    @RequiresRoles(value = {"com", "adm", "hed"}, logical = Logical.OR)
    @RequestMapping("/task/lunch")
    public ResultBean<Void> f1() {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());
        ResultBean<Void> resultBean = new ResultBean<>();
        if (subject.isPermitted(new WildcardPermission("*:lun_tsk"))) {
            resultBean.setCode(ResultBean.ALL_PASSED);
            resultBean.setMsg("发布成功");
        }
        else {
            resultBean.setCode(ResultBean.ACCESS_DENIED);
            resultBean.setMsg("您貌似没有权限");
        }
        return resultBean;
    }
}
