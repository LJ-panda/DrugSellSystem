package com.clay.system.service.imp;

import com.clay.system.mapper.PermissionMapper;
import com.clay.system.mapper.UserAndPermissionMapper;
import com.clay.system.model.enity.Permission;
import com.clay.system.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 18:53
 * @Version 1.0
 */
@Service
@AllArgsConstructor
public class PermissionServiceImp implements PermissionService
{
    private UserAndPermissionMapper mapper;

    @Override
    public List<Permission> getAll() {
        return null;
    }

    @Override
    public List<Permission> getByEmail(String email)
    {
        return mapper.queryByUserEmail(email);
    }
}
