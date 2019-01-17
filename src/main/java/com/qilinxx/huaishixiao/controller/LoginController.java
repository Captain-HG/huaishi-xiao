package com.qilinxx.huaishixiao.controller;


import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.entity.UserRole;
import com.qilinxx.huaishixiao.service.UserRoleService;
import com.qilinxx.huaishixiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * fangyusheng
 * 2019/1/15
 * 登录控制层
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    /**
     * 来到登录页面
     * @return  跳转到登录页面
     */
    @GetMapping("login")
    public String login(){
        return "login";
    }

    /**
     *
     * @param account   账号
     * @param password  密码
     * @return  登录成功跳转主页面，登录失败回到登录页面
     */
    @PostMapping("login")
    public String login(String account, String password , Model model, HttpSession session){
        //下面的账号密码验证可以用shiro代替
        User user = userService.selectByAccount(account);
        if(user==null){
            model.addAttribute("error","账号不存在");
            model.addAttribute("account",account);
            model.addAttribute("password",password);
            return "login";
        }
        if(!user.getPassword().equals(password)){
            model.addAttribute("error","密码错误");
            model.addAttribute("account",account);
            return "login";
        }
        session.setAttribute("account",account);
        List<UserRole> userRoleList = userRoleService.findRidByUid(user.getUid());
        String s="";
        for (UserRole userRole:userRoleList){
            s=s+userRole.getRid();
        }
        if(s.contains("3")){
            //跳转管理员页面
             return "redirect:/";
        }
        if(s.contains("2")){
            //跳转教师页面，并有审核权限
            session.setAttribute("rid","2");
        }
        return "redirect:/main";
    }


}
