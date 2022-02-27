package com.cootoo.devops.cmdbdatacollector.entity.model;

public class TopologyAssetDetail {
    private Long id;

    private Integer assetId;

    private String busIp;

    private String mgtIp;

    private String publicIp;

    private String sn;

    private String deviceType;

    private String virtualType;

    private String environment;

    private String cpuModel;

    private String cpuNum;

    private String cpuCores;

    private String cpuBrand;

    private String ramSize;

    private String osType;

    private String osRelease;

    private String osDistribution;

    private String idcId;

    private String idcName;

    private String idcRoomId;

    private String model;

    private String status;

    private String isDel;

    private String cabinetId;

    private String cabinetName;

    private String cabinetOrder;

    private String usageId;

    private String busUser;

    private String buyAt;

    private String createAt;

    private String updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp == null ? null : publicIp.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getVirtualType() {
        return virtualType;
    }

    public void setVirtualType(String virtualType) {
        this.virtualType = virtualType == null ? null : virtualType.trim();
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment == null ? null : environment.trim();
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel == null ? null : cpuModel.trim();
    }

    public String getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(String cpuNum) {
        this.cpuNum = cpuNum == null ? null : cpuNum.trim();
    }

    public String getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(String cpuCores) {
        this.cpuCores = cpuCores == null ? null : cpuCores.trim();
    }

    public String getCpuBrand() {
        return cpuBrand;
    }

    public void setCpuBrand(String cpuBrand) {
        this.cpuBrand = cpuBrand == null ? null : cpuBrand.trim();
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize == null ? null : ramSize.trim();
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType == null ? null : osType.trim();
    }

    public String getOsRelease() {
        return osRelease;
    }

    public void setOsRelease(String osRelease) {
        this.osRelease = osRelease == null ? null : osRelease.trim();
    }

    public String getOsDistribution() {
        return osDistribution;
    }

    public void setOsDistribution(String osDistribution) {
        this.osDistribution = osDistribution == null ? null : osDistribution.trim();
    }

    public String getIdcId() {
        return idcId;
    }

    public void setIdcId(String idcId) {
        this.idcId = idcId == null ? null : idcId.trim();
    }

    public String getIdcName() {
        return idcName;
    }

    public void setIdcName(String idcName) {
        this.idcName = idcName == null ? null : idcName.trim();
    }

    public String getIdcRoomId() {
        return idcRoomId;
    }

    public void setIdcRoomId(String idcRoomId) {
        this.idcRoomId = idcRoomId == null ? null : idcRoomId.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public String getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(String cabinetId) {
        this.cabinetId = cabinetId == null ? null : cabinetId.trim();
    }

    public String getCabinetName() {
        return cabinetName;
    }

    public void setCabinetName(String cabinetName) {
        this.cabinetName = cabinetName == null ? null : cabinetName.trim();
    }

    public String getCabinetOrder() {
        return cabinetOrder;
    }

    public void setCabinetOrder(String cabinetOrder) {
        this.cabinetOrder = cabinetOrder == null ? null : cabinetOrder.trim();
    }

    public String getUsageId() {
        return usageId;
    }

    public void setUsageId(String usageId) {
        this.usageId = usageId == null ? null : usageId.trim();
    }

    public String getBusUser() {
        return busUser;
    }

    public void setBusUser(String busUser) {
        this.busUser = busUser == null ? null : busUser.trim();
    }

    public String getBuyAt() {
        return buyAt;
    }

    public void setBuyAt(String buyAt) {
        this.buyAt = buyAt == null ? null : buyAt.trim();
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt == null ? null : createAt.trim();
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt == null ? null : updateAt.trim();
    }
}