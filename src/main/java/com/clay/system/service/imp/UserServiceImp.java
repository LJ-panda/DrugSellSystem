package com.clay.system.service.imp;

import com.clay.system.mapper.UserAndPermissionMapper;
import com.clay.system.mapper.UserMapper;
import com.clay.system.model.enity.User;
import com.clay.system.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.transaction.SystemException;
import java.util.List;
import java.util.Objects;

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

    //赋权
    private UserAndPermissionMapper upMapper;

    @Override
    public User getUserByEmail(String email)
    {
        User user=userMapper.queryUserByEmail(email);
        log.debug("service 层查询用户 Email：{}\t结果：{}",email,user);
        //return Objects.nonNull(user)?user:new User();
        return user;
    }

    /**
     * 判断是否已有
     * 并添加和授权
     * @param user
     * @return
     * @throws SystemException
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addUser(User user) throws SystemException {
        log.debug("service 层添加 User：{}",user);
        if (Objects.nonNull(userMapper.queryUserByEmail(user.getEmail())))
        {
            throw new SystemException("用户重复添加");
        }
        int v=userMapper.insertUser(user);
        User  user1=userMapper.queryUserByEmail(user.getEmail());
        log.info("查询User:{}\t权限：{}",user1,user.getPermissions());
        user.getPermissions()
                .forEach(item->upMapper.insert(item.getId(),user1.getId()));
        return v;
    }

    @Override
    public List<User> getAll()
    {
        return userMapper.queryAllUser();
    }
}
