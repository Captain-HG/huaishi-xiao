package com.qilinxx.huaishixiao.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Role implements Serializable {
    @Id
    private String rid;

    private String name;

    private Long ctime;

    private Long utime;

    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid;
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
        sb.append(", rid=").append(rid);
        sb.append(", name=").append(name);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}