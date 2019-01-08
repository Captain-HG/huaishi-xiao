package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.Permission;

import java.util.List;

public interface PermissionService {
    /** 查询所有的权限*/
    List<Permission> selectAll();
    /** 根据id查询*/
    Permission selectById(String id);
    /** 更新*/
    int update(Permission permission);
    /** 停用该权限*/
    int stopPermission(String id);
    /** 启用该权限*/
    int startPermission(String id);
    /** 增加权限*/
    int addPermission(Permission permission);
    /** 删除该对象*/
    int deletePermission(String id);
}
