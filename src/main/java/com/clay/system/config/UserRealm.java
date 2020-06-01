package com.clay.system.config;

import com.clay.system.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 16:29
 * @Version 1.0
 *
 * shiro权限系统
 * 获取用户验证信息和授权信息的配置
 * 主要是通过使用用户服务获取
 */
@AllArgsConstructor
@Slf4j
public class UserRealm extends AuthorizingRealm
{
    private UserService userService;

    /**
     * 授权信息获取
     * @param principals 用户凭证，主要是email
     * @return     授权信息，角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 获取用户认证信息
     * @param token  控制器传递的token，包含密码和email
     * @return         认证信息，主要是用数据库查询的用户验证信息
     * @throws AuthenticationException  失败时发生的认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
