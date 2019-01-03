package com.qilinxx.huaishixiao.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Permission implements Serializable {
    @Id
    private String id;

    private String name;

    private String description;

    private Long ctime;

    private Long utime;

    private String state;

    private String remark;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append(", state=").append(state);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}