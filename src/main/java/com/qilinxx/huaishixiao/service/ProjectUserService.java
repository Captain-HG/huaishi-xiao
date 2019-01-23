package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.ProjectUser;

import java.util.List;

public interface ProjectUserService {

    /***
     * 查询参与者的名字
     * @param pid 项目id
     * @return
     */
    List<String> selectAllUserNameByProjectId(String pid);

    /**
     * 更新项目与参与者关系
     * 先删除原来的在进行添加
     * @param pid 项目id
     * @param name 项目名
     * @param userId 参与者id
     * @return
     */
    int updatePU(String pid, String name, String userId);

    /**
     * 增加项目与参与者关系
     * @param pid 项目id
     * @param name 项目名
     * @param userId 参与者id
     * @return
     */
    int insertPU(String pid, String name, String userId);
    /**添加一个新的项目与用户关系*/
    void createPU(ProjectUser projectUser);
}
