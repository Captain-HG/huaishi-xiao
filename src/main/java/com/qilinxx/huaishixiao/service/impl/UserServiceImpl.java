package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.mapper.UserMapper;
import com.qilinxx.huaishixiao.service.UserRoleService;
import com.qilinxx.huaishixiao.service.UserService;
import com.qilinxx.huaishixiao.utils.DateKit;
import com.qilinxx.huaishixiao.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        user.setUtime((long) DateKit.getCurrentUnixTime());
        user.setState("0");
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int stopUser(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setUtime((long) DateKit.getCurrentUnixTime());
        user.setState("0");

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int  startUser(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setUtime((long) DateKit.getCurrentUnixTime());
        user.setState("1");

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int addUser(User user) {
        user.setUid(UUID.UU32());
        user.setCtime((long) DateKit.getCurrentUnixTime());
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return userMapper.delete(user);
    }



    @Override
    public int updateUserAndRole(User user, String roleId) {
        System.out.println("userService:"+roleId);
        updateUser(user);
        return userRoleService.update(user.getUid(),roleId);
    }

    @Override
    public int addUserAndRole(User user, String roleId) {
        addUser(user);
        return userRoleService.addUserRole(user.getUid(),roleId);
    }

    @Override
    public User selectByAccount(String account) {
        return  userMapper.selectByAccount(account);
    }
//
//    @Override
//    public List<UserVo> selectUserVoAll() {
//        List<User> userList = userMapper.selectAll();
//        List<UserVo> UserVoList = new ArrayList<>();
//        for (User user:userList){
//            UserVoList.add(copy(user));
//        }
//        return UserVoList;
//    }

//    private UserVo copy(User user) {
//        UserVo userVo = new UserVo();
//        userVo.setUid(user.getUid());
//        userVo.setAccount(user.getAccount());
//        userVo.setCtime(user.getCtime());
//        userVo.setName(user.getName());
//        userVo.setState(user.getState());
//        userVo.setType(user.getType());
//        userVo.setRoleName(userRoleService.selectRoleNameByUid(user.getUid()));
//        return userVo;
//    }
}
