package com.qilinxx.huaishixiao.mapper;

import com.qilinxx.huaishixiao.entity.File;
import com.qilinxx.huaishixiao.entity.FileExample;
import com.qilinxx.huaishixiao.utils.IBaseMapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface FileMapper extends IBaseMapper<File> {
    File selectByNameTest(String name);
  }