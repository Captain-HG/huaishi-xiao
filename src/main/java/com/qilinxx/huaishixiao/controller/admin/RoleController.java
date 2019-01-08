package com.qilinxx.huaishixiao.controller.admin;

import com.qilinxx.huaishixiao.entity.Permission;
import com.qilinxx.huaishixiao.entity.Role;
import com.qilinxx.huaishixiao.service.PermissionService;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    /**
     * 角色列表
     * @return
     */
    @RequestMapping("admin-role-list.html")
    public String roleList(Model model){
        List<Role> roleList = roleService.selectAll();
        model.addAttribute("roleList",roleList);
        model.addAttribute("commons",new Commons());
        return "admin/role/list";
  }


    /**
     * 跳转更新页面
     * @param model 传递
     * @param id role的id
     * @return
     */
    @RequestMapping("admin-role-update.html")
    public String roleUpdateUI(Model model,String id){
        Role role = roleService.selectById(id);
        List<Permission> permissionList = permissionService.selectAll();
        model.addAttribute("permissionList",permissionList);
        model.addAttribute("role",role);
        model.addAttribute("commons",new Commons());
        return "admin/role/update";
    }

    /**
     * 角色更新实现
     * @param role
     * @return
     */
    @RequestMapping("admin-role-update")
    @ResponseBody
    public  int  roleUpdate(Role role,String[] permissionValue){
        System.out.println(role);
        return roleService.updateRoleAndPermission(role,permissionValue);
    }


    /**
     * 增加页面跳转
     * @return
     */
    @RequestMapping("admin-role-add.html")
    public String addRoleUI(Model model){
        List<Permission> permissionList = permissionService.selectAll();
        model.addAttribute("permissionList",permissionList);
        return "admin/role/add";
    }

    /***
     * 增加用户
     * @param role 用户
     * @param  permissionValue 权限值
     * @return
     */
    @RequestMapping("admin-role-add")
    @ResponseBody
    public int addRole(Role role,String[] permissionValue){
        System.out.println(role);
        return roleService.addRoleAndPermission(role,permissionValue);
    }

    /**
     * 删除角色
     * @param id 用户id
     * @return
     */
    @RequestMapping("admin-role-del")
    @ResponseBody
    public int delRole(String id) {
        System.out.println("delRId:"+id);
        return roleService.deleteRole(id);
    }
}