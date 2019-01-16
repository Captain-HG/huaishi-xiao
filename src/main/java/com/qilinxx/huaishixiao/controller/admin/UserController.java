package com.qilinxx.huaishixiao.controller.admin;

import com.qilinxx.huaishixiao.entity.Role;
import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.service.UserService;
import com.qilinxx.huaishixiao.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;


    @RequestMapping("user-show.html")
    public String member_show(String uid,Model model){
        System.out.println(uid);
        User student= userService.selectById(uid);
        model.addAttribute("user",student);
        model.addAttribute("commons",new Commons());
        return "user/show";
    }
    /**
     * 用户列表
     * @return
     */
    @RequestMapping("admin-user-list.html")
    public  String userList(Model model){
        List<User> userList = userService.selectAll();
        model.addAttribute("userList",userList);
        model.addAttribute("commons",new Commons());
        return "admin/user/list";
    }
    /**
     * 跳转更新页面
     * @param model 传递
     * @param id user的id
     * @return
     */
    @RequestMapping("admin-user-update.html")
    public String userUpdateUI(Model model,String id){
        User user = userService.selectById(id);
        List<Role> roleList = roleService.selectAll();
        model.addAttribute("user",user);
        model.addAttribute("roleList",roleList);
        model.addAttribute("commons",new Commons());
        return "admin/user/update";
    }

    /**
     * 更新实现
     * @param user
     * @return
     */
    @RequestMapping("admin-user-update")
    @ResponseBody
    public  int  userUpdate(User user,String roleId){
        System.out.println(user);
        System.out.println("权限id:"+roleId);
        int i = userService.updateUserAndRole(user,roleId);
        System.out.println("更新返回："+i);
        return i;
    }
    /**
     * 审核此用户失效
     * @param id  用户id
     * @return 成功
     */
    @RequestMapping("admin-user-stopUser")
    @ResponseBody
    public int stopUser(String id) {
        System.out.println("userId:"+id);

        return  userService.stopUser(id);
    }
    /**
     * 用户启用
     * @param id  用户id
     * @return 成功
     */
    @RequestMapping("admin-user-startUser")
    @ResponseBody
    public int startUser(String id) {
        System.out.println("userId:"+id);

        return  userService.startUser(id);
    }

    /**
     * 增加页面跳转
     * @return
     */
    @RequestMapping("admin-user-add.html")
    public String addUserUI(Model model){
        List<Role> roleList = roleService.selectAll();
        model.addAttribute("roleList",roleList);
        return "admin/user/add";
    }

    /***
     * 增加用户
     * @param user 用户
     * @return
     */
    @RequestMapping("admin-user-add")
    @ResponseBody
    public int addUser(User user,String roleId){

        return userService.addUserAndRole(user,roleId);
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    @RequestMapping("admin-user-del")
    @ResponseBody
    public int delUser(String id) {
        return userService.deleteUser(id);
    }

    /**
     * 验证账号是否已经被注册
     * @param
     * @return
     */
    @RequestMapping("admin-user-accountAjaxRegister")
    @ResponseBody
    public String userAjaxRegister(String account,String uid) {
        String str="";
        User user = userService.selectByAccount(account);
        if (user==null){
            str="true";
        }
        else{
            if (uid!=null){
                User userById = userService.selectById(uid);
                if (userById.getAccount().equals(account)){
                    str="true";
                }else {
                    str="error";
                }
            }
            else {
                str="error";
            }
        }
        return str;
    }
}
