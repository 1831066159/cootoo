package com.cootoo.devops.cmdbdatacollector.dao;

import com.cootoo.devops.cmdbdatacollector.entity.model.TopologyAssetDetail;

public interface TopologyAssetDetailMapper {
    int insert(TopologyAssetDetail record);

    int insertSelective(TopologyAssetDetail record);
}