package com.qilinxx.huaishixiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @GetMapping("test")
    public String test(Model model){
        String path= "upload\\11111111111111111111111111111111\\project\\1548573696779\\1548573696779_a.jpg";
        String path2="upload\\doc.doc";
        String path3="upload\\pdf.pdf";
        model.addAttribute("path",path);
        model.addAttribute("path2",path2);
        model.addAttribute("path3",path3);
        return "test";
    }
    @GetMapping("viewer")
    public String viewer(Model model){
        String path= "upload\\11111111111111111111111111111111\\project\\1548573696779\\1548573696779_a.jpg";
        String path2="upload\\doc.doc";
        String path3="upload\\pdf.pdf";
        model.addAttribute("path",path);
        model.addAttribute("path2",path2);
        model.addAttribute("path3",path3);
        return "redirect:/pdf/web/viewer.html?file=/preview";
    }

    @RequestMapping("/no")
    public String index(){
        return "no";
    }


}
