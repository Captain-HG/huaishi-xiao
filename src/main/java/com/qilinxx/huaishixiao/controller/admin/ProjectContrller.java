package com.qilinxx.huaishixiao.controller.admin;

import com.qilinxx.huaishixiao.entity.Project;
import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.service.ProjectService;
import com.qilinxx.huaishixiao.service.UserService;
import com.qilinxx.huaishixiao.utils.Commons;
import com.qilinxx.huaishixiao.vo.ProjectUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectContrller {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    /**
     * 项目列表
     * @return
     */
    @RequestMapping("admin-project-list.html")
    public  String projectList(Model model){
       //项目列表应该包含参与者，而项目文件应该在点击进去查看
        List<ProjectUserVo> projectUserVos = projectService.selectProjectAndUserAll();
        model.addAttribute("projectUserVos",projectUserVos);
        model.addAttribute("commons",new Commons());
        return "admin/project/list";
    }
    /**
     * 跳转更新页面
     * @param model 传递
     * @param id project的id
     * @return
     */
    @RequestMapping("admin-project-update.html")
    public String projectUpdateUI(Model model,String id){
        Project project = projectService.selectById(id);
        List<User> userList = userService.selectAll();
        model.addAttribute("userList",userList);
        model.addAttribute("project",project);
        model.addAttribute("commons",new Commons());
        return "admin/project/update";
    }

    /**
     * 更新实现
     * @param project 项目对象
     * @param  userIds 参与人数组
     * @return
     */
    @RequestMapping("admin-project-update")
    @ResponseBody
    public  int  projectUpdate(Project project,String[] userIds){
        return projectService.updateProjectAndUser(project,userIds);
    }
    /**
     * 审核此项目失效
     * @param id  项目id
     * @return 成功
     */
    @RequestMapping("admin-project-stopProject")
    @ResponseBody
    public int stopproject(String id) {
        System.out.println("projectId:"+id);

        return  projectService.stopProject(id);
    }
    /**
     * 项目启用
     * @param id  项目id
     * @return 成功
     */
    @RequestMapping("admin-project-startProject")
    @ResponseBody
    public int startproject(String id) {
        System.out.println("projectId:"+id);

        return  projectService.startProject(id);
    }

    /**
     * 增加页面跳转
     * @return
     */
    @RequestMapping("admin-project-add.html")
    public String addprojectUI(Model model){
        List<User> userList = userService.selectAll();
        model.addAttribute("userList",userList);
        return "admin/project/add";
    }

    /***
     * 增加项目
     * @param project 项目
     * @param userIds 参与人数组
     * @return
     */
    @RequestMapping("admin-project-add")
    @ResponseBody
    public int addProject(Project project,String[] userIds){

       return projectService.addPU(project,userIds);
    }

    /**
     * 删除项目
     * @param id 项目id
     * @return
     */
    @RequestMapping("admin-project-del")
    @ResponseBody
    public int delProject(String id) {
        return projectService.delete(id);
    }
}
