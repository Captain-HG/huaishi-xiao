package com.qilinxx.huaishixiao.controller;


import com.qilinxx.huaishixiao.entity.Log;
import com.qilinxx.huaishixiao.service.LogService;
import com.qilinxx.huaishixiao.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: dqsdc
 * @Date: 2019-1-17 14:54
 * @Description:
 */
@Controller
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("system-log.html")
    public String showSystemLog(HttpServletRequest request){
        List<Log> logs=logService.getAllLog();
        request.setAttribute("logs",logs);
        request.setAttribute("commons",new Commons());
        request.setAttribute("size",logs.size());
        return "system-log.html";
    }
}
