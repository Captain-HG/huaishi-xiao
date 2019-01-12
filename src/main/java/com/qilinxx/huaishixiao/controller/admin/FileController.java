package com.qilinxx.huaishixiao.controller.admin;


import com.qilinxx.huaishixiao.entity.File;
import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.service.FileService;
import com.qilinxx.huaishixiao.service.ProjectService;
import com.qilinxx.huaishixiao.utils.Commons;
import com.qilinxx.huaishixiao.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    ProjectService projectService;

    /**
     * 文件列表
     * @param model 传递
     * @param pId 项目id
     * @return
     */
    @RequestMapping("admin-file-list.html")
    public  String fileList(Model model,String pId){
        List<FileVo> fileVos = fileService.selectAllFileVoByPid(pId);
        System.out.println(fileVos);
        model.addAttribute("fileVos",fileVos);
        //把项目名字放过去
        model.addAttribute("project", projectService.selectById(pId));

        model.addAttribute("commons",new Commons());
        return "admin/file/list";
    }
    /**
     * 跳转更新页面
     * @param model 传递
     * @param id file的id
     * @return
     */
    @RequestMapping("admin-file-update.html")
    public String fileUpdateUI(Model model, String id){
        File file = fileService.selectById(id);
        model.addAttribute("file",file);
        model.addAttribute("commons",new Commons());
        return "admin/file/update";
    }

    /**
     * 更新实现
     * @param file 文件对象
     * @param  userIds 参与人数组
     * @return
     */
    @RequestMapping("admin-file-update")
    @ResponseBody
    public  int  fileUpdate(File file,String[] userIds){
        return 0;
    }
    /**
     * 审核此文件失效
     * @param id  文件id
     * @return 成功
     */
    @RequestMapping("admin-file-stopFile")
    @ResponseBody
    public int stopFile(String id) {
        System.out.println("fileId:"+id);
        return  fileService.stopFile(id);
    }
    /**
     * 文件启用
     * @param id  文件id
     * @return 成功
     */
    @RequestMapping("admin-file-startFile")
    @ResponseBody
    public int startFile(String id) {
        System.out.println("fileId:"+id);

        return  fileService.startFile(id);
    }

    /**
     * 增加页面跳转
     * @return
     */
    @RequestMapping("admin-file-add.html")
    public String addFileUI(Model model){
        return "admin/file/add";
    }

    /***
     * 增加文件
     * @param file 文件
     * @param userIds 参与人数组
     * @return
     */
    @RequestMapping("admin-file-add")
    @ResponseBody
    public int addFile(File file, String[] userIds){

        return 0;
    }

    /**
     * 删除文件
     * @param id 文件id
     * @return
     */
    @RequestMapping("admin-file-del")
    @ResponseBody
    public int delFile(String id) {
        return fileService.delete(id);
    }
}