package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    /** 根据用户id查询角色名称*/
    String selectRoleNameByUid(String uid);
    /** 更新用户角色关系*/
    int update(String uid, String roleId);
    /** 增加用户角色关系*/
    int addUserRole(String uid, String roleId);
    /**根据用户id查询角色id*/
    List<UserRole> findRidByUid(String uid);
}
