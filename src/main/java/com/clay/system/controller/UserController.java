package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.model.vo.VoUser;
import com.clay.system.service.UserService;
import com.clay.system.utils.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:31
 * @Version 1.0
 *
 * 关于用户服务的封装
 * 后期需要新增权限控制
 *
 * 需要服务：{@link UserService}
 */
@Slf4j
@Validated
@RestController
@RequestMapping(value = "/api/user")
@AllArgsConstructor
@SuppressWarnings("all")
public class UserController
{
    private UserService userService;
    /**
     * 登陆处理接口
     * @param email   email
     * @param password      password
     * @return  info
     */
    @Description(description = "登陆接口")
    @PostMapping(value = "/login")
    public SystemResponse login(@NotBlank(message = "email不可为空")String email,
                                @NotBlank(message = "密码不可为空")String password)
    {
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken upt=new UsernamePasswordToken(email, password);
        subject.login(upt);          //委托shiro处理
        return new SystemResponse()
                .success()
                .message("ok")
                .data(Boolean.TRUE);
    }

    /**
     * 新增用户
     * 此处需要权限：user:insert
     * @param user 待新增的用户
     * @return
     */
    @RequiresPermissions("user:insert")
    @Description(description = "用户新增")
    @PostMapping(value = "/add")
    public SystemResponse add(@Validated VoUser user)
    {
        userService.addUser(ConvertUtils.buildUserByVo(user));
        return new SystemResponse()
                .success()
                .message("ok")
                .data(null);
    }

    /**
     * 获取用户列表
     * 此处需要权限：user:queryAll
     * @return
     */
    @RequiresPermissions("user:queryAll")
    @Description(description = "获取用户列表")
    @GetMapping(value = "query")
    public SystemResponse queryAll()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(userService.getAll());
    }
}
