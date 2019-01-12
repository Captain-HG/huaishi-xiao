package com.qilinxx.huaishixiao.mapper;

import com.qilinxx.huaishixiao.entity.ProjectUser;
import com.qilinxx.huaishixiao.entity.ProjectUserExample;
import com.qilinxx.huaishixiao.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectUserMapper extends IBaseMapper<ProjectUser> {
    /** 根据pid查询所有*/
    List<ProjectUser> selectAllByPId(String pid);
    /** 根据项目id删除原先有的*/
    void deleteByPId(String pid);
}