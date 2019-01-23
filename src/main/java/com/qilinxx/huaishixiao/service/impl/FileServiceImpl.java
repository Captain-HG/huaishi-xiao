package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.entity.File;
import com.qilinxx.huaishixiao.mapper.FileMapper;
import com.qilinxx.huaishixiao.mapper.UserMapper;
import com.qilinxx.huaishixiao.service.FileService;
import com.qilinxx.huaishixiao.utils.DateKit;
import com.qilinxx.huaishixiao.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public File selectById(String id) {
        return fileMapper.selectByPrimaryKey(id);
    }

    @Override
    public int stopFile(String id) {
        File file = fileMapper.selectByPrimaryKey(id);
        file.setIsuse("0");
        file.setUpdatetime((long) DateKit.getCurrentUnixTime());
        return fileMapper.updateByPrimaryKeySelective(file);
    }

    @Override
    public int startFile(String id) {
        File file = fileMapper.selectByPrimaryKey(id);
        file.setIsuse("1");
        file.setUpdatetime((long) DateKit.getCurrentUnixTime());
        return fileMapper.updateByPrimaryKeySelective(file);
    }

    @Override
    public int delete(String id) {
        File file = fileMapper.selectByPrimaryKey(id);
        return fileMapper.delete(file);
    }

    @Override
    public List<FileVo> selectAllFileVoByPid(String pId) {
        List<File> files = fileMapper.selectAllByPId(pId);
        List<FileVo> fileVoList = new ArrayList<>();
        for (File file:files){
            fileVoList.add(copy(file));
        }
        return fileVoList;
    }

    @Override
    public void createFile(File file) {
        fileMapper.insert(file);
    }

    @Override
    public void createFileList(List<File> fileList) {
        fileMapper.insertList(fileList);
    }


    private FileVo copy(File file) {
        FileVo fileVo = new FileVo();
        fileVo.setId(file.getId());
        fileVo.setCreatetime(file.getCreatetime());
        fileVo.setIsuse(file.getIsuse());
        fileVo.setFilename(file.getFilename());
        fileVo.setPath(file.getPath());
        fileVo.setState(file.getState());
        fileVo.setTitle(file.getTitle());
        fileVo.setType(file.getType());
        fileVo.setCreaterName(userMapper.selectByPrimaryKey(file.getCreateUid()).getName());
        fileVo.setExamerName(userMapper.selectByPrimaryKey(file.getExamerUid()).getName());
        return fileVo;
    }
}
