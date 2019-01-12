package com.qilinxx.huaishixiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    /**
     * 管理员首页跳转
     * @param model
     * @return
     */
    @RequestMapping("admin-index")
    public String adminIndex(Model model){
        return "admin/index";
    }
}
