package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.Project;
import com.qilinxx.huaishixiao.entity.ProjectExample;
import com.qilinxx.huaishixiao.entity.ProjectUser;
import com.qilinxx.huaishixiao.mapper.ProjectMapper;
import com.qilinxx.huaishixiao.mapper.ProjectUserMapper;
import com.qilinxx.huaishixiao.service.ProjectService;
import com.qilinxx.huaishixiao.service.ProjectUserService;
import com.qilinxx.huaishixiao.service.UserService;
import com.qilinxx.huaishixiao.utils.DateKit;
import com.qilinxx.huaishixiao.utils.UUID;
import com.qilinxx.huaishixiao.vo.ProjectUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    UserService userService;
    @Autowired
    ProjectUserService projectUserService;

    @Override
    public Project selectById(String id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateProjectAndUser(Project project, String[] userIds) {
        project.setUtime((long) DateKit.getCurrentUnixTime());

        for(int i=0;i<userIds.length;i++){
           projectUserService.updatePU(project.getId(),project.getName(),userIds[i]);
        }
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public int startProject(String id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        project.setState("2");
        project.setUtime((long) DateKit.getCurrentUnixTime());
        return projectMapper.updateByPrimaryKeySelective(project);
    }
    @Override
    public int stopProject(String id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        project.setState("1");
        project.setUtime((long) DateKit.getCurrentUnixTime());
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public List<ProjectUserVo> selectProjectAndUserAll() {
        List<Project> projects = projectMapper.selectAll();
        List<ProjectUserVo> projectUserVos = new ArrayList<>();
        for (Project project:projects){
            projectUserVos.add(copy(project));

        }
        return projectUserVos;
    }

    @Override
    public int addPU(Project project, String[] userIds) {
        project.setId(UUID.UU32());
        project.setCtime((long) DateKit.getCurrentUnixTime());
        for(int i=0;i<userIds.length;i++){
            projectUserService.insertPU(project.getId(),project.getName(),userIds[i]);
        }
       return projectMapper.insert(project);
    }

    @Override
    public int delete(String id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        return  projectMapper.delete(project);
    }

    @Override
    public void createProject(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public List<Project> findProjectByNameAndCreateId(String name, String createId) {
        ProjectExample example=new ProjectExample();
        example.createCriteria().andNameEqualTo(name).andCreaterIdEqualTo(createId);
        return  projectMapper.selectByExample(example);
    }

    @Override
    public List<Project> findProjectExceptCreateId(String createId) {
        ProjectExample example=new ProjectExample();
        example.createCriteria().andCreaterIdNotEqualTo(createId);
        return projectMapper.selectByExample(example);
    }


    /**
     * 封装
     * @param project 项目对象
     * @return
     */
    private ProjectUserVo copy(Project project) {
        ProjectUserVo projectUserVo = new ProjectUserVo();
         projectUserVo.setId(project.getId());
         projectUserVo.setState(project.getState());
         projectUserVo.setCtime(project.getCtime());
         projectUserVo.setName(project.getName());
         projectUserVo.setDetail(project.getDetail());
         projectUserVo.setPath(project.getPath());
         projectUserVo.setType(project.getType());
         projectUserVo.setUtime(project.getUtime());
         projectUserVo.setCreaterName(userService.selectById(project.getCreaterId()).getName());
         projectUserVo.setUserNameList(projectUserService.selectAllUserNameByProjectId(project.getId()));
        return projectUserVo;
    }


}
