package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.vo.UserVo;

import java.util.List;

public interface UserService {
    /** 查询所有*/
    List<User> selectAll();
    /** 根据id查询用户*/
    User selectById(String id);
    /** 更新用户*/
    int updateUser(User user);
    /** 停用该用户*/
    int stopUser(String id);
    /** 开启用户*/
    int startUser(String id);
    /** 增加用户*/
    int addUser(User user);
    /** 根据id删除用户*/
    int deleteUser(String id);
    /** 判断账号是否存在*/
    String ifAccountUse(String account);
//    /** 查询封装过后的user*/
//    List<UserVo> selectUserVoAll();
}
