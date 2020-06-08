package com.clay.system.mapper;


import com.clay.system.model.enity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 19:46
 * @Version 1.0
 *
 * 用户对象映射
 */
@Repository
public interface UserMapper
{
    int insertUser(User user);

    List<User> queryAllUser();

    User queryUserByEmail(String email);

    User queryById(int id);

    void delById(int id);

    void updateUserStatus(int id);
}
