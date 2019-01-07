package com.qilinxx.huaishixiao.mapper;

import com.qilinxx.huaishixiao.entity.UserRole;
import com.qilinxx.huaishixiao.entity.UserRoleExample;
import com.qilinxx.huaishixiao.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends IBaseMapper<UserRole> {
    /** 根据用户id查询对象*/
    UserRole selectByUid(String uid);
}