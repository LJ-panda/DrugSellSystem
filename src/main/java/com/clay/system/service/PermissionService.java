package com.clay.system.service;

import com.clay.system.model.enity.Permission;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 18:53
 * @Version 1.0
 */
public interface PermissionService
{
    List<Permission> getAll();
    List<Permission> getByEmail(String email);
}
