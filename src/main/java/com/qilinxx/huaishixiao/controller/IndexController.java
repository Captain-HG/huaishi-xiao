package com.qilinxx.huaishixiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/welcome.html")
    public String index(){
        return "/backstage/welcome";
    }

}