package com.learn.springbootshiroa.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SuanCaiYv
 * @time 2020/4/23 下午3:51
 */
@RestController
public class LoginInController {

    @PostMapping("/doLogin")
    public String doLoginIn(@RequestParam("email") String email, @RequestParam("password") String password) {
        Subject currSubject = SecurityUtils.getSubject();
        try {
            currSubject.login(new UsernamePasswordToken(email, password));
            return "success";
        } catch (AuthenticationException e) {
            System.out.println("Login Failed");
        }
        return "fail";
    }

    @RequestMapping("/login")
    public String haveLoginedIn() {
        return "Hello";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
