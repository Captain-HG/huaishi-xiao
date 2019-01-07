package com.qilinxx.huaishixiao.service.impl;

import com.qilinxx.huaishixiao.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl {
    @Autowired
    PermissionMapper permissionMapper;
}
