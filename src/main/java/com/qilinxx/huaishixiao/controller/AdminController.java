package com.qilinxx.huaishixiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    /**
     * 管理员首页跳转
     */
    @RequestMapping("admin-index")
    public String adminIndex(){
        return "admin/index";
    }

    @RequestMapping("admin-index-show")
    public String index(){
        return "admin/welcome";
    }
}
