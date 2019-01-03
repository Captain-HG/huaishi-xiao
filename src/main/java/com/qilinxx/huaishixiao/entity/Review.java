package com.qilinxx.huaishixiao.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Review implements Serializable {
    @Id
    private String id;

    private String uid;

    private String pid;

    private String result;

    private String state;

    private Long ctime;

    private Long utime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return ctime
     */
    public Long getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    /**
     * @return utime
     */
    public Long getUtime() {
        return utime;
    }

    /**
     * @param utime
     */
    public void setUtime(Long utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", pid=").append(pid);
        sb.append(", result=").append(result);
        sb.append(", state=").append(state);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append("]");
        return sb.toString();
    }
}