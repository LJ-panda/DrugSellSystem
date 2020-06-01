package com.clay.system.service.imp;

import com.clay.system.mapper.UserMapper;
import com.clay.system.model.enity.User;
import com.clay.system.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 16:45
 * @Version 1.0
 *
 * 用户服务层的实现
 * 查询无对象就通过返回空对象？
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImp implements UserService
{
    private UserMapper userMapper;

    @Override
    public User getUserByEmail(String email)
    {
        User user=userMapper.queryUserByEmail(email);
        log.debug("service 层查询用户 Email：{}\t结果：{}",email,user);
        //return Objects.nonNull(user)?user:new User();
        return user;
    }

    @Override
    public int addUser(User user)
    {
        log.debug("service 层添加 User：{}",user);
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> getAll()
    {
        return userMapper.queryAllUser();
    }
}
