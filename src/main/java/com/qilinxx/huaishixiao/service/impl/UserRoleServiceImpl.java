package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.UserRole;
import com.qilinxx.huaishixiao.mapper.UserRoleMapper;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.service.UserRoleService;
import com.qilinxx.huaishixiao.utils.UUID;
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

    @Override
    public int update(String uid, String roleId) {
        System.out.println("userRole:"+uid+","+roleId);
        UserRole userRole = userRoleMapper.selectByUid(uid);
        System.out.println("userRole:"+userRole);
        userRole.setRid(roleId);
        return userRoleMapper.updateByPrimaryKeySelective(userRole);
    }

    @Override
    public int addUserRole(String uid, String roleId) {
        UserRole userRole = new UserRole();
        userRole.setId(UUID.UU32());
        userRole.setRid(roleId);
        userRole.setUid(uid);
        return userRoleMapper.insert(userRole);
    }
}
