package com.qilinxx.huaishixiao.service;

public interface UserRoleService {
    /** 根据用户id查询角色名称*/
    String selectRoleNameByUid(String uid);
}
