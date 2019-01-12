package com.qilinxx.huaishixiao.vo;

import com.qilinxx.huaishixiao.entity.File;

/**
 * 文件包装
 */
public class FileVo extends File {
    String createrName;//创建人
    String examerName;//审核人

    public FileVo() {
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getExamerName() {
        return examerName;
    }

    public void setExamerName(String examerName) {
        this.examerName = examerName;
    }
}
