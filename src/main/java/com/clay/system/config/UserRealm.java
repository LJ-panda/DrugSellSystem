package com.clay.system.config;

import com.clay.system.model.enity.Permission;
import com.clay.system.model.enity.User;
import com.clay.system.service.PermissionService;
import com.clay.system.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

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
 * 类似于一个专用数据源
 */
@AllArgsConstructor
@Slf4j
public class UserRealm extends AuthorizingRealm
{
    private UserService userService;

    private PermissionService permissionService;

    /**
     * 授权信息获取
     * @param principals 用户凭证，主要是email
     * @return     授权信息，角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        List<Permission>permissionList=permissionService.getByEmail(principals.getPrimaryPrincipal().toString());
        Set<String>strPermission=new LinkedHashSet<>();
        permissionList.forEach(a-> strPermission.add(a.getName()));
        authorizationInfo.setStringPermissions(strPermission);
        return authorizationInfo;
    }

    /**
     * 获取用户认证信息
     * @param token  控制器传递的token，包含密码和email
     * @return         认证信息，主要是用数据库查询的用户验证信息
     * @throws AuthenticationException  失败时发生的认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException
    {
        String email=token.getPrincipal().toString().trim();
        User user=userService.getUserByEmail(email);

        log.debug("认证 Email：{}\t获取 User：{}",email,user);

        user= Objects.nonNull(user)?user:new User();   //避免发生空指针异常
        if (user.getStatus()==-1)
        {
            throw new LockedAccountException("用户状态锁定！");
        }
        return new SimpleAuthenticationInfo(user.getEmail(),user.getPassword(),"userRealm");
    }


}
