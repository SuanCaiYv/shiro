package com.learn.shiro.controller;

import com.learn.shiro.dao.shiro.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author SuanCaiYv
 * @time 2020/6/13 下午3:40
 */
@RestController
public class ControllerTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @RequestMapping("/test")
    public void f(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("我是汉字");
        response.getWriter().flush();
    }
}
