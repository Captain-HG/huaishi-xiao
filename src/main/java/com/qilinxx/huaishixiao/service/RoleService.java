package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.Role;

import java.util.List;

public interface RoleService {
     /** 角色列表*/
    List<Role> selectAll();
    /** 主键查询*/
    Role selectById(String id);
    /** 更新*/
    int updaterole(Role role);
    /** 增加角色*/
    int addRole(Role role);
    /** 删除角色*/
    int deleteRole(String id);
}
