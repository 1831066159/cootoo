package com.cootoo.mapi.topology.common.entity;

import java.util.Date;

public class TopologyAutoProjectAppRel {
    private Integer id;

    private Long tLeftId;

    private Byte tLeftType;

    private Long tRightId;

    private Byte tRightType;

    private Long throughput;

    private String itime;

    private String createBy;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long gettLeftId() {
        return tLeftId;
    }

    public void settLeftId(Long tLeftId) {
        this.tLeftId = tLeftId;
    }

    public Byte gettLeftType() {
        return tLeftType;
    }

    public void settLeftType(Byte tLeftType) {
        this.tLeftType = tLeftType;
    }

    public Long gettRightId() {
        return tRightId;
    }

    public void settRightId(Long tRightId) {
        this.tRightId = tRightId;
    }

    public Byte gettRightType() {
        return tRightType;
    }

    public void settRightType(Byte tRightType) {
        this.tRightType = tRightType;
    }

    public Long getThroughput() {
        return throughput;
    }

    public void setThroughput(Long throughput) {
        this.throughput = throughput;
    }

    public String getItime() {
        return itime;
    }

    public void setItime(String itime) {
        this.itime = itime == null ? null : itime.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}