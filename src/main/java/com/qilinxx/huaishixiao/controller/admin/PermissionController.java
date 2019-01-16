package com.qilinxx.huaishixiao.controller.admin;

import com.qilinxx.huaishixiao.entity.Permission;

import com.qilinxx.huaishixiao.service.PermissionService;
import com.qilinxx.huaishixiao.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    /**
     * 权限所有
     * @param model
     * @return
     */
    @RequestMapping("admin-permission-list.html")
    public String permissionList(Model model){
        List<Permission> permissionList = permissionService.selectAll();
        model.addAttribute("permissionList",permissionList);
        model.addAttribute("commons",new Commons());
        return "admin/permission/list";
    }
    /**
     * 跳转更新页面
     * @param model 传递
     * @param id permission的id
     * @return
     */
    @RequestMapping("admin-permission-update.html")
    public String permissionUpdateUI(Model model,String id){
        Permission permission = permissionService.selectById(id);
        model.addAttribute("permission",permission);
        return "admin/permission/update";
    }

    /**
     * 更新实现
     * @param permission
     * @return
     */
    @RequestMapping("admin-permission-update")
    @ResponseBody
    public  int  permissionUpdate(Permission permission){
        System.out.println(permission);
      
        int i = permissionService.update(permission);
        System.out.println("更新返回："+i);
        return i;
    }
    /**
     * 审核此权限失效
     * @param id  权限id
     * @return 成功
     */
    @RequestMapping("admin-permission-stopPermission")
    @ResponseBody
    public int stopPermission(String id) {
        System.out.println("permissionId:"+id);

        return  permissionService.stopPermission(id);
    }
    /**
     * 权限启用
     * @param id  权限id
     * @return 成功
     */
    @RequestMapping("admin-permission-startPermission")
    @ResponseBody
    public int startPermission(String id) {
        System.out.println("permissionId:"+id);

        return  permissionService.startPermission(id);
    }

    /**
     * 增加页面跳转
     * @return
     */
    @RequestMapping("admin-permission-add.html")
    public String addPermissionUI(Model model){
        return "admin/permission/add";
    }

    /***
     * 增加权限
     * @param permission 权限
     * @return
     */
    @RequestMapping("admin-permission-add")
    @ResponseBody
    public int addPermission(Permission permission,String roleId){

        return permissionService.addPermission(permission);
    }

    /**
     * 删除权限
     * @param id 权限id
     * @return
     */
    @RequestMapping("admin-permission-del")
    @ResponseBody
    public int delPermission(String id) {
        return permissionService.deletePermission(id);
    }

}
