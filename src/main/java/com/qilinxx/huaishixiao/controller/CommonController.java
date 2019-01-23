package com.qilinxx.huaishixiao.controller;

import com.qilinxx.huaishixiao.utils.UploadUtil;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Auther: dqsdc
 * @Date: 2018-11-20 14:21
 * @Description: 存放一些公共调用资源，如动态验证码等
 */
@Controller
public class CommonController {


    @RequestMapping("/upload")
    @ResponseBody
    public String uploads(@RequestParam("file") MultipartFile sortPicImg) throws Exception {

        String path = UploadUtil.getUploadFilePath() + "/upload";//存储的根路径

        String fileName = System.currentTimeMillis() + "_" + sortPicImg.getOriginalFilename(); //动态文件名
        //保存文件
        File targetFile = new File(path, fileName);
        FileCopyUtils.copy(sortPicImg.getInputStream(), new FileOutputStream(targetFile));

        //生成对应的json数据（目前是相对路径）
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        File relativeFile = new File("upload", fileName);
        json.put("filePath", relativeFile.getPath());
        System.out.println("json=" + json.toJSONString());
        return json.toJSONString();
    }
}
