package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.ProjectUser;
import com.qilinxx.huaishixiao.mapper.ProjectUserMapper;
import com.qilinxx.huaishixiao.mapper.UserMapper;
import com.qilinxx.huaishixiao.service.ProjectUserService;
import com.qilinxx.huaishixiao.utils.UUID;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectUserServiceImpl implements ProjectUserService {
    @Autowired
    ProjectUserMapper projectUserMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<String> selectAllUserNameByProjectId(String pid) {
        //返回姓名集合，根据userid
        List<String> userNameList = new ArrayList<>();
        List<ProjectUser> projectUsers = projectUserMapper.selectAllByPId(pid);
        for(ProjectUser pu:projectUsers){
        userNameList.add(userMapper.selectByPrimaryKey(pu.getUserId()).getName());
        }
        return userNameList;
    }

    @Override
    public int updatePU(String pid, String name, String userId) {
        projectUserMapper.deleteByPId(pid);
        return insertPU(pid,name,userId);
    }

    @Override
    public int insertPU(String pid, String name, String userId) {
        ProjectUser pu = new ProjectUser();
        pu.setId(UUID.UU32());
        pu.setUserId(userId);
        pu.setProjectName(name);
        pu.setProjectId(pid);
        pu.setState("1");
        return projectUserMapper.insert(pu);
    }
}
