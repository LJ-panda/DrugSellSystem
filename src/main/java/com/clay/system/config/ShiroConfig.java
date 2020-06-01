package com.clay.system.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
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
 */
@Configuration
public class ShiroConfig
{
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager)
    {
        ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        Map<String, String>filterMap = new LinkedHashMap<>();
        filterMap.put("/toLogin","anon");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    @Bean
    public SecurityManager securityManager(UserRealm userRealm)
    {
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm()
    {
        return new UserRealm();
    }

//    @Bean
//    public SessionDAO sessionDAO(RedisManager redisManager)
//    {
//       RedisSessionDAO sessionDAO=new RedisSessionDAO();
//       sessionDAO.setRedisManager(redisManager);
//        sessionDAO.setExpire(60*10);
//       return sessionDAO;
//    }

    @Bean
    public SessionManager sessionManager()
    {

        return new DefaultWebSessionManager();
    }

    @Bean
    public CacheManager cacheManager(RedisManager redisManager)
    {
        RedisCacheManager cacheManager=new RedisCacheManager();
        cacheManager.setExpire(60*10);
        cacheManager.setRedisManager(redisManager);
        return cacheManager;
    }

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
