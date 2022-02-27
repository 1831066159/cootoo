package com.cootoo.devops.apicronjob.dao;

import com.cootoo.devops.apicronjob.model.KDevopsOpLog;

public interface KDevopsOpLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(KDevopsOpLog record);

    int insertSelective(KDevopsOpLog record);

    KDevopsOpLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KDevopsOpLog record);

    int updateByPrimaryKey(KDevopsOpLog record);
}