package com.qilinxx.huaishixiao.service;

public interface RolePermissionService {
    /** 增加角色权限*/
    void insert(String rid, String pid);
    /** 批量删除根据角色id*/
    void deleteByRId(String rid);
}
