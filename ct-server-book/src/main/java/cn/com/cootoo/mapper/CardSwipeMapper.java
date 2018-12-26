package cn.com.cootoo.mapper;

import cn.com.cootoo.model.CardSwipe;

public interface CardSwipeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardSwipe record);

    int insertSelective(CardSwipe record);

    CardSwipe selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardSwipe record);

    int updateByPrimaryKey(CardSwipe record);
}