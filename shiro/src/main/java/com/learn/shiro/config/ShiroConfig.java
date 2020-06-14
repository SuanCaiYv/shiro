package com.learn.shiro.config;

import com.learn.shiro.dao.shiro.WebRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author SuanCaiYv
 * @time 2020/6/9 下午4:27
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private WebRealm webRealm;

    /**
     * 进一步根据访问路径配置更详细的过滤器，add()的第二个参数代表了过滤器的名字
     * @return NA
     * 来看详细的解释
     * anon: AnonymousFilter，允许不做验证直接访问，相当于不加过滤器
     * authc: FormAuthenticationFilter，要求请求的用户必须是已验证的，否则强制重定向到设置好的登录界面
     * authcBasic: BasicHttpAuthenticationFilter，要求org.apache.shiro.subject.Subject#isAuthenticated()返回真，否则要求登录
     * authcBearer: BearerHttpAuthenticationFilter，和上面效果差不多，协议种类不同
     * logout: LogoutFilter，对当前用户进行登出操作，并重定向到设定好的“重定向Url”
     * noSessionCreation: NoSessionCreationFilter，禁用Session的创建，对于可能产生REST，SOAP等交互结果的操作很有用
     * perms: PermissionsAuthorizationFilter，如果当前用户拥有map指定的值时，允许访问
     * port: PortFilter把请求限定在某一指定端口，如果请求不在此端口发起请求，那么重定向到这个端口
     * rest: HttpMethodPermissionFilter，把HTTP请求方法转换成一个行为值，并用这个值构建一个许可用来进行授权验证
     * roles: RolesAuthorizationFilter，当当前用户持有map包含的值之一时，允许访问，如果持有的所有角色都没被包含，拒绝访问
     * ssl: SslFilter，如果是SSL加密的，允许，否则拒绝
     * user: UserFilter，如果是已知用户，允许访问，判别方法：principal是否被标记，或者说，任何已验证的，已被“记住”的均可访问
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        shiroFilterChainDefinition.addPathDefinition("/doLogin", "anon");
        shiroFilterChainDefinition.addPathDefinition("/**", "authc");
        return shiroFilterChainDefinition;
    }

    @PostConstruct
    public void init() {

        SecurityUtils.setSecurityManager(securityManager());
    }

    /**
     * 关于SecurityUtils.getSubject()的个人理解，因为tomcat是多线程的，所以每次获取的Subject是怎么保证是当前与应用交互的Subject的呢？
     * 答案就是ThreadLocal。这个类利用Map针对每个线程获取线程的独立于其他线程的域，怎么做到的呢？
     * 这个Map的key不是不同的，而是全部是ThreadLocal类，但是有多个Map，每个线程都保存了一个Map，每个Map都有一个key为ThreadLocal的键值对。
     * 这个和我们平时使用的Map有点不一样，平时想保存多个键值对，无非多个键对应多个值，这个是多个Map对应多个值，每个Map都有某一确定的值
     * 想获取不同的值不是通过改变key的方式而是，通过改变Map的方式来实现，而Map绑定在线程上，遂直接获取当前线程的Map就好。
     * 所以SecurityUtils.getSubject()是获取当前线程的Map的key为"ThreadContext_SUBJECT_KEY"的键值对的值来获取Subject的。
     * @return NA
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(cacheManager());
        securityManager.setRealm(webRealm);
        return securityManager;
    }

    @Bean
    public SessionManager sessionManager() {

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        return sessionManager;
    }

    @Bean
    public CacheManager cacheManager() {

        EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
    }


    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

}
