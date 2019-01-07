package com.qilinxx.huaishixiao.vo;

import com.qilinxx.huaishixiao.entity.User;

public class UserVo extends User {
    private String roleName;//角色名

    public UserVo(String roleName) {
        this.roleName = roleName;
    }
    public UserVo(){

    }
    @Override
    public String toString() {
        return "UserVo{" +
                "roleName='" + roleName + '\'' +
                '}';
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
