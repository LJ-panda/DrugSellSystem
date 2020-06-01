package com.clay.system.config;

import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 16:34
 * @Version 1.0
 */
@Configuration
public class RedisConfig
{
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Bean
    public RedisManager redisManager()
    {
        RedisManager redisManager=new RedisManager();
        redisManager.setHost(host+":"+port);
        return redisManager;
    }
}
