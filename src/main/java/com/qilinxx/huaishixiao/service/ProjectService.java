package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.Project;
import com.qilinxx.huaishixiao.vo.ProjectUserVo;

import java.util.List;

public interface ProjectService {
    /** 根据id查询对象*/
    Project selectById(String id);
    /** 更新项目和参与者*/
    int updateProjectAndUser(Project project, String[] userIds);
    /** 启用项目*/
    int startProject(String id);
    /** 停用项目*/
    int stopProject(String id);
    /** 包含项目，参与者，创建人*/
    List<ProjectUserVo> selectProjectAndUserAll();
    /** 增加项目，与参与者*/
    int addPU(Project project, String[] userIds);
    /** 根据id删除*/
    int delete(String id);
    /**添加一个新项目*/
    void createProject(Project project);
    /**通过名称和创建人id查找项目*/
    List<Project> findProjectByNameAndCreateId(String name,String createId);
}
