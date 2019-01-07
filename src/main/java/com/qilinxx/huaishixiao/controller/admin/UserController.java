package com.qilinxx.huaishixiao.controller.admin;

import com.qilinxx.huaishixiao.entity.User;
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
        model.addAttribute("user",user);
        model.addAttribute("commons",new Commons());
        return "admin/user/update";
    }
    @RequestMapping("admin-user-update")
    @ResponseBody
    public  int  userUpdate(User user){
        System.out.println(user);
        int i = userService.updateUser(user);
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
    public String addUserUI(){
        return "admin/user/add";
    }

    /***
     * 增加用户
     * @param user 用户
     * @return
     */
    @RequestMapping("admin-user-user-add")
    @ResponseBody
    public int addUser(User user){
        return userService.addUser(user);
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
    public String userAjaxRegister(String account,String id) {
        System.out.println("id和账号："+account+id);
        User user = userService.selectById(id);
        if (account.equals(user.getAccount())) {
            return "true";
        } else {

            return userService.ifAccountUse(account);
        }
    }
}
