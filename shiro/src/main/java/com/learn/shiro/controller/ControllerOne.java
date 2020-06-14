package com.learn.shiro.controller;

import com.learn.shiro.result.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SuanCaiYv
 * @time 2020/6/9 下午9:12
 */
@RestController
public class ControllerOne {

    @RequestMapping("/doLogin")
    public ResultBean<Void> doLogin(String email, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(email);
        token.setPassword(password.toCharArray());
        Subject subject = SecurityUtils.getSubject();
        ResultBean<Void> resultBean = new ResultBean<>();
        if (subject.isAuthenticated()) {
            return resultBean;
        }
        try {
            subject.login(token);
            token.setRememberMe(true);
            resultBean.setMsg("登录成功");
            resultBean.setCode(ResultBean.ALL_PASSED);
        } catch (IncorrectCredentialsException e) {
            resultBean.setMsg("密码错误");
            resultBean.setCode(ResultBean.INCORRECT_PASSWORD);
        } catch (ExpiredCredentialsException e) {
            resultBean.setMsg("密码过期");
            resultBean.setCode(ResultBean.LOCKED_USER);
        } catch (UnknownAccountException e) {
            resultBean.setMsg("用户未注册");
            resultBean.setCode(ResultBean.UNSIGNED_USER);
        }
        return resultBean;
    }


    @RequestMapping("/logout")
    public ResultBean<Void> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResultBean<>();
    }

    @RequestMapping("/unauth")
    public String error() {
        return "unauth";
    }

    @RequestMapping("/login")
    public String  login() {
        return "please login!";
    }
}
