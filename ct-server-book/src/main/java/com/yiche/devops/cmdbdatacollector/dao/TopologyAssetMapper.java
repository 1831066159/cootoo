package com.cootoo.devops.cmdbdatacollector.dao;

import com.cootoo.devops.cmdbdatacollector.entity.model.TopologyAsset;

public interface TopologyAssetMapper {
    int insert(TopologyAsset record);

    int insertSelective(TopologyAsset record);
}