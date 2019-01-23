package com.qilinxx.huaishixiao.service;



import com.qilinxx.huaishixiao.entity.Log;

import java.util.List;

/**
 * @Auther: LJM
 * @Date: 2018-09-27 11:45
 * @Description: 日志操作服务类
 */
public interface LogService {

    void insertLog(String action, String userId, String Ip);

    List<Log>  getAllLog();

    List<Log> getAdminLoginLog();
}
