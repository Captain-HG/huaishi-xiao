package com.qilinxx.huaishixiao.controller;

import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * fangyusheng
 * 2019/1/16
 * 教师端控制层
 */
@Controller
public class TeacherController {
    @Autowired
    UserService userService;
    /**
     * @return 跳转到教师端后台主页面
     */
    @GetMapping("main")
    public String main(HttpSession session, Model model){
         String account=(String) session.getAttribute("account");
         //以下代码项目完成修改
        User user=userService.selectByAccount("13123456789");
        //以上代码项目完成时修改
        model.addAttribute("name",user.getName());
        return "teacher/main";
    }
}
