package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.Role;
import com.qilinxx.huaishixiao.mapper.RoleMapper;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.utils.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public Role selectById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updaterole(Role role) {
        role.setUtime((long) DateKit.getCurrentUnixTime());
        return roleMapper.updateByPrimaryKeySelective(role);
    }




    @Override
    public int addRole(Role role) {
        role.setCtime((long) DateKit.getCurrentUnixTime());
        return roleMapper.insert(role);
    }

    @Override
    public int deleteRole(String id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return roleMapper.delete(role);
    }
}
