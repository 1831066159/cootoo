package com.cootoo.mapi.topology.common.entity;

import java.util.Date;

public class TopologyAutoApplication {
    private Long id;

    private String applicationName;

    private String alias;

    private Integer applicationType;

    private String applicationUrl;

    private String applicationOwner;

    private String applicationVersion;

    private String description;

    private Long projectId;

    private Byte isHide;

    private Byte status;

    private Short instanceCount;

    private Byte instanceStatus;

    private String instanceStatusDetail;

    private String department;

    private Integer aname;

    private Integer cid;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private String source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Integer getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Integer applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl == null ? null : applicationUrl.trim();
    }

    public String getApplicationOwner() {
        return applicationOwner;
    }

    public void setApplicationOwner(String applicationOwner) {
        this.applicationOwner = applicationOwner == null ? null : applicationOwner.trim();
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion == null ? null : applicationVersion.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Byte getIsHide() {
        return isHide;
    }

    public void setIsHide(Byte isHide) {
        this.isHide = isHide;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Short getInstanceCount() {
        return instanceCount;
    }

    public void setInstanceCount(Short instanceCount) {
        this.instanceCount = instanceCount;
    }

    public Byte getInstanceStatus() {
        return instanceStatus;
    }

    public void setInstanceStatus(Byte instanceStatus) {
        this.instanceStatus = instanceStatus;
    }

    public String getInstanceStatusDetail() {
        return instanceStatusDetail;
    }

    public void setInstanceStatusDetail(String instanceStatusDetail) {
        this.instanceStatusDetail = instanceStatusDetail == null ? null : instanceStatusDetail.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getAname() {
        return aname;
    }

    public void setAname(Integer aname) {
        this.aname = aname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}