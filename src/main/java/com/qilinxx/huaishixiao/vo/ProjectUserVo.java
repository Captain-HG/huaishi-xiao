package com.qilinxx.huaishixiao.vo;

import com.qilinxx.huaishixiao.entity.Project;

import java.util.List;

public class ProjectUserVo extends Project {
   String createrName;//创建人
   List<String> userNameList;//参与集合

    public ProjectUserVo() {

    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }
}
