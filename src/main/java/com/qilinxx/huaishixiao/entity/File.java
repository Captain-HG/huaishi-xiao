package com.qilinxx.huaishixiao.entity;

import java.io.Serializable;
import javax.persistence.*;

public class File implements Serializable {
    @Id
    private String id;

    private String filename;

    private String type;

    private String path;

    private String title;

    private String isuse;

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "create_uid")
    private String createUid;

    @Column(name = "createTime")
    private Long createtime;

    @Column(name = "updater_uid")
    private String updaterUid;

    @Column(name = "updateTime")
    private Long updatetime;

    @Column(name = "examer_uid")
    private String examerUid;

    private String details;

    private Boolean state;

    private String remark;

    private String text;

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
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return isuse
     */
    public String getIsuse() {
        return isuse;
    }

    /**
     * @param isuse
     */
    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    /**
     * @return project_id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return create_uid
     */
    public String getCreateUid() {
        return createUid;
    }

    /**
     * @param createUid
     */
    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    /**
     * @return createTime
     */
    public Long getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    /**
     * @return updater_uid
     */
    public String getUpdaterUid() {
        return updaterUid;
    }

    /**
     * @param updaterUid
     */
    public void setUpdaterUid(String updaterUid) {
        this.updaterUid = updaterUid;
    }

    /**
     * @return updateTime
     */
    public Long getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return examer_uid
     */
    public String getExamerUid() {
        return examerUid;
    }

    /**
     * @param examerUid
     */
    public void setExamerUid(String examerUid) {
        this.examerUid = examerUid;
    }

    /**
     * @return details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return state
     */
    public Boolean getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Boolean state) {
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

    /**
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", filename=").append(filename);
        sb.append(", type=").append(type);
        sb.append(", path=").append(path);
        sb.append(", title=").append(title);
        sb.append(", isuse=").append(isuse);
        sb.append(", projectId=").append(projectId);
        sb.append(", createUid=").append(createUid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updaterUid=").append(updaterUid);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", examerUid=").append(examerUid);
        sb.append(", details=").append(details);
        sb.append(", state=").append(state);
        sb.append(", remark=").append(remark);
        sb.append(", text=").append(text);
        sb.append("]");
        return sb.toString();
    }
}