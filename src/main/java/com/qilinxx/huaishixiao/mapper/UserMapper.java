package com.qilinxx.huaishixiao.mapper;

import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.entity.UserExample;
import com.qilinxx.huaishixiao.utils.IBaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends IBaseMapper<User> {
     /** 根据账号查询用户*/
    User selectByAccount(String account);
}