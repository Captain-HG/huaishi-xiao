package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.RolePermission;
import com.qilinxx.huaishixiao.mapper.RolePermissionMapper;
import com.qilinxx.huaishixiao.service.RolePermissionService;
import com.qilinxx.huaishixiao.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public void insert(String rid, String pid) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setId(UUID.UU32());
        rolePermission.setPid(pid);
        rolePermission.setRid(rid);
        rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public void deleteByRId(String rid) {
        rolePermissionMapper.deleteByRId(rid);
    }
}
