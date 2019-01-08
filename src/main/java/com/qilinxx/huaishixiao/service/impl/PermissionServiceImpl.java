package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.Permission;
import com.qilinxx.huaishixiao.mapper.PermissionMapper;
import com.qilinxx.huaishixiao.service.PermissionService;
import com.qilinxx.huaishixiao.service.RolePermissionService;
import com.qilinxx.huaishixiao.utils.DateKit;
import com.qilinxx.huaishixiao.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RolePermissionService rolePermissionService;

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public Permission selectById(String id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Permission permission) {
        permission.setUtime((long) DateKit.getCurrentUnixTime());
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public int stopPermission(String id) {
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        permission.setState("0");
        permission.setUtime((long) DateKit.getCurrentUnixTime());
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public int startPermission(String id) {
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        permission.setState("1");
        permission.setUtime((long) DateKit.getCurrentUnixTime());
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public int addPermission(Permission permission) {
       permission.setId(UUID.UU32());
       permission.setCtime((long) DateKit.getCurrentUnixTime());
       //不管你增加多少权限，管理员都应该拥有
       rolePermissionService.insert("3",permission.getId());
       return permissionMapper.insert(permission);
    }

    @Override
    public int deletePermission(String id) {
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        return permissionMapper.delete(permission);
    }
}
