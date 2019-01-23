package com.qilinxx.huaishixiao.mapper;


import com.qilinxx.huaishixiao.entity.Log;
import com.qilinxx.huaishixiao.utils.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper extends IBaseMapper<Log> {
    List<Log> selectAdminLogin();
}