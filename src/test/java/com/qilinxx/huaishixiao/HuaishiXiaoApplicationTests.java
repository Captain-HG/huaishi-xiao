package com.qilinxx.huaishixiao;

import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.mapper.FileMapper;
import com.qilinxx.huaishixiao.mapper.UserMapper;
import com.qilinxx.huaishixiao.service.UserService;
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
    UserService userService;
  @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        System.out.println("mapper测试："+fileMapper.selectAll());
        System.out.println("xml测试："+fileMapper.selectByNameTest("lzc"));
    }
   @Test
    public void test01(){
       User user = userMapper.selectByPrimaryKey("1");
       user.setAccount("123");
       int i = userService.updateUser(user);
       System.out.println("测试更新："+i);

   }
}

