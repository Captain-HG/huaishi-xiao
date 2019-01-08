package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.Role;

import java.util.List;

public interface RoleService {
     /** 角色列表*/
    List<Role> selectAll();
    /** 主键查询*/
    Role selectById(String id);
    /** 更新*/
    int updateRole(Role role);
    /** 增加角色*/
    int addRole(Role role);
    /** 删除角色*/
    int deleteRole(String id);
    /** 更新*/
    int updateRoleAndPermission(Role role, String[] permissionValue);
    /** 增加*/
    int addRoleAndPermission(Role role, String[] permissionValue);
}
