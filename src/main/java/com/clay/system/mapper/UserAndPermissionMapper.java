package com.clay.system.mapper;

import com.clay.system.model.enity.Permission;
import com.clay.system.model.enity.UserAndPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 18:45
 * @Version 1.0
 */
@Repository
public interface UserAndPermissionMapper
{
    List<Permission> queryByUserEmail(String email);

    int insert(int pId,int uId);

    void delByUid(int uId);

    UserAndPermission queryBy(int uId,int pId);
}
