package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.mapper.UserRoleMapper;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleService roleService;
    @Override
    public String selectRoleNameByUid(String uid) {

        return null;
    }
}
