package com.clay.system.mapper;

import com.clay.system.model.enity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 18:38
 * @Version 1.0
 */
@Repository
public interface PermissionMapper
{
    List<Permission> queryAll();

    Permission queryById(int id);
}
