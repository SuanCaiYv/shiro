package com.learn.shiro.filter;

import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author SuanCaiYv
 * @time 2020/6/13 下午1:44
 */
@WebFilter(value = "/*", filterName = "shiroFilter", initParams = {
        @WebInitParam(name = "targetFilterLifecycle", value = "true")})
public class ShiroFilter extends DelegatingFilterProxy {
}
