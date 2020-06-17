package com.clay.system.service;

import com.clay.system.exception.DrugSystemException;
import com.clay.system.model.enity.User;


import javax.transaction.SystemException;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 16:40
 * @Version 1.0
 *
 * 用户服务接口
 */
public interface UserService
{
    User getUserByEmail(String email);

    int addUser(User user) throws DrugSystemException;

    List<User> getAll();

    void delById(int id) throws DrugSystemException;

    void changeUserStatus(int id) throws  DrugSystemException;
}
