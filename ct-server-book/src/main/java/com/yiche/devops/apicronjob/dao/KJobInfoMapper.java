package com.cootoo.devops.apicronjob.dao;

import com.cootoo.devops.apicronjob.model.KJobInfo;

public interface KJobInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(KJobInfo record);

    int insertSelective(KJobInfo record);

    KJobInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KJobInfo record);

    int updateByPrimaryKey(KJobInfo record);
}