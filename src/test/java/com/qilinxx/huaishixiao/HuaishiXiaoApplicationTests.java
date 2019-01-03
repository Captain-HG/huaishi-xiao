package com.qilinxx.huaishixiao;

import com.qilinxx.huaishixiao.mapper.FileMapper;
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
    @Test
    public void contextLoads() {
        System.out.println("mapper测试："+fileMapper.selectAll());
        System.out.println("xml测试："+fileMapper.selectByNameTest("lzc"));
    }

}

