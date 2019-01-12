package com.qilinxx.huaishixiao;

import com.qilinxx.huaishixiao.entity.Role;
import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.mapper.FileMapper;
import com.qilinxx.huaishixiao.mapper.RoleMapper;
import com.qilinxx.huaishixiao.mapper.UserMapper;
import com.qilinxx.huaishixiao.mapper.UserRoleMapper;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.service.UserService;
import com.qilinxx.huaishixiao.utils.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuaishiXiaoApplicationTests {
  @Autowired
    FileMapper fileMapper;
  @Autowired
    RoleMapper roleMapper;
  @Autowired
    UserService userService;
  @Autowired
    UserMapper userMapper;
  @Autowired
    UserRoleMapper userRoleMapper;
  @Autowired
    RoleService roleService;


   @Test
    public void test01(){
       User user = userMapper.selectByPrimaryKey("1");
       user.setAccount("123");
       int i = userService.updateUser(user);
       System.out.println("测试更新："+i);
   }
   @Test
    public void test02(){
       System.out.println(userRoleMapper.selectByUid("1"));
   }
    @Test
    public void test03(){
        Role role = roleMapper.selectByPrimaryKey(null);
        System.out.println(role);
    }
}

