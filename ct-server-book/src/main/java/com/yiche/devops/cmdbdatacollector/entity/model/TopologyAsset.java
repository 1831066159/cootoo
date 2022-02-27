package com.cootoo.devops.cmdbdatacollector.entity.model;

import java.util.Date;

public class TopologyAsset {
    private Long id;

    private String name;

    private Integer assetId;

    private String busIp;

    private String mgtIp;

    private String virtualType;

    private String idcName;

    private String status;

    private Byte deployStatus;

    private String levelName;

    private String departmentId;

    private String departmentName;

    private String description;

    private String source;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getBusIp() {
        return busIp;
    }

    public void setBusIp(String busIp) {
        this.busIp = busIp == null ? null : busIp.trim();
    }

    public String getMgtIp() {
        return mgtIp;
    }

    public void setMgtIp(String mgtIp) {
        this.mgtIp = mgtIp == null ? null : mgtIp.trim();
    }

    public String getVirtualType() {
        return virtualType;
    }

    public void setVirtualType(String virtualType) {
        this.virtualType = virtualType == null ? null : virtualType.trim();
    }

    public String getIdcName() {
        return idcName;
    }

    public void setIdcName(String idcName) {
        this.idcName = idcName == null ? null : idcName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Byte getDeployStatus() {
        return deployStatus;
    }

    public void setDeployStatus(Byte deployStatus) {
        this.deployStatus = deployStatus;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
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
}