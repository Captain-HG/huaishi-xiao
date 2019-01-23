package com.qilinxx.huaishixiao.service;

import com.qilinxx.huaishixiao.entity.File;
import com.qilinxx.huaishixiao.vo.FileVo;

import java.util.List;

public interface FileService {
    /** 根据id查询*/
    File selectById(String id);
    /** 停用*/
    int stopFile(String id);
    /** 开启*/
    int startFile(String id);
    /** 删除*/
    int delete(String id);
    /** 查询所有的封装好的filevo,根据项目id*/
    List<FileVo> selectAllFileVoByPid(String pId);
    /**创建新的文件记录*/
    void createFile(File file);
    /***/
    void createFileList(List<File> fileList);
}
