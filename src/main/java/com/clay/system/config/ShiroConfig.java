package com.clay.system.config;

import com.clay.system.service.PermissionService;
import com.clay.system.service.UserService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 16:25
 * @Version 1.0
 *
 * 安全框架shiro的配置
 */
@Configuration
public class ShiroConfig
{
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager)
    {
        ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        //其它
        shiroFilter.setLoginUrl("/view/user/toLogin");
        shiroFilter.setUnauthorizedUrl("/view/user/toLogin");
        Map<String, String>filterMap = new LinkedHashMap<>();
        //静态资源
        filterMap.put("/css/**","anon");
        filterMap.put("/img/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/scss/**","anon");
        filterMap.put("/vendor/**","anon");

        //免认证的请求
        filterMap.put("/view/user/toLogin","anon");
        filterMap.put("/api/user/login","anon");

        filterMap.put("/view/part/details","anon");
        filterMap.put("/view/test","anon");
        //需要认证的url
        //filterMap.put("/**","authc");

        filterMap.put("/**","anon");

        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;

//        ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager);
//        Map<String,String>filterMap=new LinkedHashMap<>();
//        filterMap.put("/api/user/login","anon");
//        filterMap.put("/view/user/toLogin","anon");
//        //暂时省略部分
//        filterMap.put("/*","authc");
//        shiroFilter.setFilterChainDefinitionMap(filterMap);
//        shiroFilter.setUnauthorizedUrl("/view/user/toLogin");
//        return shiroFilter;
    }

    @Bean
    public SecurityManager securityManager(UserRealm userRealm)
    {
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(UserService userService, PermissionService permissionService)
    {
        UserRealm userRealm=new UserRealm(userService,permissionService);
        userRealm.setCachingEnabled(true);
        userRealm.setAuthorizationCachingEnabled(true);
        userRealm.setAuthenticationCachingEnabled(true);
        return userRealm;
    }

//    @Bean
//    public SessionDAO sessionDAO(RedisManager redisManager)
//    {
//       RedisSessionDAO sessionDAO=new RedisSessionDAO();
//       sessionDAO.setRedisManager(redisManager);
//        sessionDAO.setExpire(60*10);
//       return sessionDAO;
//    }

//    @Bean
//    public SessionManager sessionManager()
//    {
//
//        return new DefaultWebSessionManager();
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisManager redisManager)
//    {
//        RedisCacheManager cacheManager=new RedisCacheManager();
//        cacheManager.setExpire(60*10);
//        cacheManager.setRedisManager(redisManager);
//        return cacheManager;
//    }

    /**
     * 开启注解权限
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor advisor(SecurityManager securityManager)
    {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
