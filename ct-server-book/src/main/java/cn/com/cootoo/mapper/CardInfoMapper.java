package cn.com.cootoo.mapper;

import cn.com.cootoo.model.CardInfo;

public interface CardInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardInfo record);

    int insertSelective(CardInfo record);

    CardInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardInfo record);

    int updateByPrimaryKey(CardInfo record);
}