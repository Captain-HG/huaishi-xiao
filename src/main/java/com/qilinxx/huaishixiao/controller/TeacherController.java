package com.qilinxx.huaishixiao.controller;

import com.qilinxx.huaishixiao.entity.Project;
import com.qilinxx.huaishixiao.entity.ProjectUser;
import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.service.FileService;
import com.qilinxx.huaishixiao.service.ProjectService;
import com.qilinxx.huaishixiao.service.ProjectUserService;
import com.qilinxx.huaishixiao.service.UserService;
import com.qilinxx.huaishixiao.utils.DateKit;
import com.qilinxx.huaishixiao.utils.SaveFile;
import com.qilinxx.huaishixiao.utils.UploadUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * fangyusheng
 * 2019/1/16
 * 教师端控制层
 */
@Controller
public class TeacherController {
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectUserService projectUserService;
    @Autowired
    FileService fileService;
    /**
     * @return 跳转到教师端后台主页面
     */
    @GetMapping({"main","1"})
    public String main(HttpSession session, Model model){
         //以下代码项目完成修改
        session.setAttribute("account","13123456789");
        //以上代码项目完成时修改
        return "teacher/main";
    }
    /**
     * @return 跳转到教师端后台左侧菜单栏
     */
    @GetMapping("left")
    public String left(){
        return "teacher/left";
    }
    /**
     * @return 跳转到教师端后台顶部导航栏
     */
    @GetMapping("top")
    public String top(HttpSession session, Model model){
        String account=(String) session.getAttribute("account");
        //以下代码项目完成修改
        User user=userService.selectByAccount("13123456789");
        //以上代码项目完成时修改
        model.addAttribute("name",user.getName());
        return "teacher/top";
    }
    /**
     * @return 跳转到教师端后台主页
     */
    @GetMapping("index")
    public String index(){
        return"teacher/index";
    }

    /**
     * 展示教师个人信息
     * @return  跳转个人信息页面
     */
    @GetMapping("info")
    public String info(Model model,HttpSession session){
        model.addAttribute("user",userService.selectByAccount((String)session.getAttribute("account")));
        return "teacher/info/info";
    }

    /**
     * 修改教师个人信息
     * @return  来到修改信息页面
     */
    @GetMapping("info-change")
    public String infoChange(Model model,HttpSession session){
        model.addAttribute("user",userService.selectByAccount((String)session.getAttribute("account")));
        return "teacher/info/info-change";
    }

    /**
     * aja修改个人信息
     * @param user  由页面得到的修改信息
     */
    @PostMapping("ajax-info-change")
    @ResponseBody
    public JSONObject ajaxInfoChange(User user,HttpSession session) {
        JSONObject json=new JSONObject();
        user.setUid(userService.selectByAccount((String) session.getAttribute("account")).getUid());
        userService.updateUser(user);
        json.put("msg","修改成功待审核！");
        return json;
    }

    /**
     * 修改密码页面
     * @return  来到修改密码页面
     */
    @GetMapping("password-change")
    public String passwordChange(Model model,HttpSession session){
        model.addAttribute("user",userService.selectByAccount((String)session.getAttribute("account")));
        return "teacher/info/password-change";
    }

    /**
     * ajax修改密码
     * @param password  新输入的密码
     */
    @PostMapping("ajax-password-change")
    @ResponseBody
    public JSONObject ajaxInfoChange(String password,HttpSession session){
        JSONObject json=new JSONObject();
        User user=new User();
        user.setUid(userService.selectByAccount((String) session.getAttribute("account")).getUid());
        user.setPassword(password);
        userService.updatePassword(user);
        json.put("msg","密码修改成功！");
        return json;
    }

    /**
     * @return  来到上传页面
     */
    @GetMapping("upload")
    public String article(HttpSession session){
        User user = userService.selectByAccount((String) session.getAttribute("account"));
        List<MultipartFile> fileList = SaveFile.getFileList();
        if(fileList==null){
            List<MultipartFile> files=new ArrayList<>();
            SaveFile.setFileList(files);
        }else {
            SaveFile.clearFileList();
            SaveFile.deleteFile(new File(UploadUtil.getUploadFilePath() + "/upload//"+user.getUid()+"//temp"));
        }
        return "teacher/project/upload";
    }


    /**
     * ajax上传论文
     * @param avatar    上传文件名
     * @throws IOException  抛出输入输出异常
     */
    @PostMapping("ajax-article-form")
    @ResponseBody
    public JSONObject ajaxArticleForm(Project project,MultipartFile avatar,HttpSession session) throws IOException {
        JSONObject json=new JSONObject();
        User user = userService.selectByAccount((String) session.getAttribute("account"));
        //判断是否重复提交
        List<Project> projectList = projectService.findProjectByNameAndCreateId(project.getName(), user.getUid());
        if(projectList.size()!=0){
            json.put("msg","此论文重复提交！");
            return json;
        }
        //以下是文件处理
        long time=System.currentTimeMillis();
        String fileName = time+ "_" + avatar.getOriginalFilename();//动态文件名
        String path = UploadUtil.getUploadFilePath() + "/upload//"+user.getUid()+"//article//"+time;//存储的根路径
        File targetFile = new File(path, fileName);
        File pathFile=new File(path);
        if (!pathFile.exists()){
            pathFile.mkdirs();
        }
        FileCopyUtils.copy(avatar.getInputStream(), new FileOutputStream(targetFile));
        //以上是文件处理
        project.setId(UUID.randomUUID().toString().replace("-",""));
        project.setCreaterId(user.getUid());
        project.setCtime(DateKit.getUnixTimeLong());
        project.setPath("upload\\"+user.getUid()+"\\article\\"+time+"\\"+fileName);
        project.setType("0");
        project.setState("0");
        ProjectUser projectUser=new ProjectUser();
        projectUser.setId(UUID.randomUUID().toString().replace("-",""));
        projectUser.setProjectId(project.getId());
        projectUser.setProjectName(project.getName());
        projectUser.setUserId(project.getCreaterId());
        projectService.createProject(project);
        projectUserService.createPU(projectUser);


        json.put("msg","发布成功待审核！");
        return json;
    }

    @PostMapping("ajax-file-form")
    @ResponseBody
    public JSONObject ajaxFileForm(MultipartFile file,HttpSession session) throws IOException {
        JSONObject json=new JSONObject();
        User user = userService.selectByAccount((String) session.getAttribute("account"));
        List<MultipartFile> fileList=SaveFile.getFileList();
        //手动去重
        int i=0;
        if(fileList.size()!=0){
            for (MultipartFile multipartFile:fileList) {
                if(multipartFile.getOriginalFilename().equals(file.getOriginalFilename())){
                    i++;
                }
            }
        }
        if (i==0){
            fileList.add(file);
            SaveFile.setFileList(fileList);

            String path = UploadUtil.getUploadFilePath() + "/upload//"+user.getUid()+"//temp";//存储的根路径 临时文件目录
            File pathFile=new File(path);
            if (!pathFile.exists()){
                pathFile.mkdirs();
            }
            String fileName = file.getOriginalFilename();//原文件名
            File targetFile = new File(path, fileName);
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(targetFile));
        }
        json.put("msg","上传成功！");
        return json;
    }

    @PostMapping("ajax-project-form")
    @ResponseBody
    public JSONObject ajaxProjectForm(Project project, HttpSession session ,String people) throws IOException {
        JSONObject json=new JSONObject();
        //以下是三种错误
        List<MultipartFile> fileList=SaveFile.getFileList();
        User user = userService.selectByAccount((String) session.getAttribute("account"));
        List<Project> projectList = projectService.findProjectByNameAndCreateId(project.getName(), user.getUid());
        if(projectList.size()!=0){
            json.put("msg","此项目重复提交！");
            return json;
        }
        if(fileList.size()==0){
            json.put("msg","上传文件为空！");
            return json;
        }
        //以下是文件和数据库处理
        project.setId(UUID.randomUUID().toString().replace("-",""));
        String[] names = people.trim().split("、");
        for (String name:names) {
            List<User> userList = userService.findUserByName(name);
            if(userList.size()==0){
                json.put("msg","未查询到 \'"+name+"\' 的相关信息！");
                return json;
            }else {
                ProjectUser projectUser=new ProjectUser();
                projectUser.setId(UUID.randomUUID().toString().replace("-",""));
                projectUser.setProjectId(project.getId());
                projectUser.setProjectName(project.getName());
                projectUser.setUserId(userList.get(0).getUid());
                projectUserService.createPU(projectUser);
            }
        }
        //以上是三种错误

        project.setCreaterId(user.getUid());
        project.setCtime(DateKit.getUnixTimeLong());
        project.setType("1");
        project.setState("0");
        projectService.createProject(project);
        long time=System.currentTimeMillis();
        String path = UploadUtil.getUploadFilePath() + "/upload//"+user.getUid()+"//project//"+time;//存储的根路径
        File pathFile=new File(path);
        if (!pathFile.exists()){
            pathFile.mkdirs();
        }
        com.qilinxx.huaishixiao.entity.File dbFile=new com.qilinxx.huaishixiao.entity.File();
        dbFile.setIsuse("0");
        dbFile.setProjectId(project.getId());
        dbFile.setCreateUid(user.getUid());
        dbFile.setCreatetime(DateKit.getUnixTimeLong());
        for (MultipartFile file:fileList) {
            String fileName = time + "_" + file.getOriginalFilename();//动态文件名
            File targetFile = new File(path, fileName);
            File tempFile=new File(UploadUtil.getUploadFilePath() + "/upload//"+user.getUid()+"//temp",file.getOriginalFilename());
            FileCopyUtils.copy(tempFile,targetFile);
            tempFile.delete();

            dbFile.setId(UUID.randomUUID().toString().replace("-",""));
            dbFile.setTitle(file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")));
            dbFile.setFilename(fileName);
            dbFile.setType(fileName.substring(fileName.lastIndexOf(".")));
            dbFile.setPath("upload\\"+user.getUid()+"\\project\\"+time+"\\"+fileName);
            fileService.createFile(dbFile);
        }
        //清空临时文件和temp目录
        SaveFile.clearFileList();
        SaveFile.deleteFile(new File(UploadUtil.getUploadFilePath() + "/upload//"+user.getUid()+"//temp"));
        //以上是文件和数据库处理
        json.put("msg","发布成功待审核！");
        return json;
    }

}
