package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.Role;
import com.qilinxx.huaishixiao.entity.RolePermission;
import com.qilinxx.huaishixiao.mapper.RoleMapper;
import com.qilinxx.huaishixiao.service.PermissionService;
import com.qilinxx.huaishixiao.service.RolePermissionService;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.utils.DateKit;
import com.qilinxx.huaishixiao.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePermissionService rolePermissionService;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public Role selectById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateRole(Role role) {
        role.setUtime((long) DateKit.getCurrentUnixTime());
        return roleMapper.updateByPrimaryKeySelective(role);
    }




    @Override
    public int addRole(Role role) {
        role.setRid(UUID.UU32());
        role.setCtime((long) DateKit.getCurrentUnixTime());
        return roleMapper.insert(role);
    }

    @Override
    public int deleteRole(String id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return roleMapper.delete(role);
    }

    @Override
    public int updateRoleAndPermission(Role role, String[] permissionValue) {
        //更新角色，所拥有的权限可能减少也可能增加，现将所有该角色的权限去除，在进行添加
        rolePermissionService.deleteByRId(role.getRid());
        for(int i=0;i<permissionValue.length;i++){
            rolePermissionService.insert(role.getRid(),permissionValue[i]);
        }

        return updateRole(role);
    }

    @Override
    public int addRoleAndPermission(Role role, String[] permissionValue) {
        role.setRid(UUID.UU32());
        role.setCtime((long) DateKit.getCurrentUnixTime());
        System.out.println(role);
       for(int i=0;i<permissionValue.length;i++){
          rolePermissionService.insert(role.getRid(),permissionValue[i]);
       }
        return roleMapper.insert(role) ;
    }
}
