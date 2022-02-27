package com.cootoo.mapi.topology.shuffle.mapper.holmes;

import com.cootoo.mapi.topology.shuffle.entity.holmes.holmesApiNameDim;

public interface holmesApiNameDimMapper {
    int insert(holmesApiNameDim record);

    int insertSelective(holmesApiNameDim record);
}