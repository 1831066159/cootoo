package com.cootoo.mapi.topology.common.mapper;

import com.cootoo.mapi.topology.common.entity.TopologyAutoProjectAppRel;
import com.cootoo.mapi.topology.common.entity.TopologyAutoProjectAppRelExample;
import org.apache.ibatis.annotations.Param;

public interface TopologyAutoProjectAppRelMapper {
    long countByExample(TopologyAutoProjectAppRelExample example);

    int deleteByExample(TopologyAutoProjectAppRelExample example);

    int insert(TopologyAutoProjectAppRel record);

    int insertSelective(TopologyAutoProjectAppRel record);

    int updateByExampleSelective(@Param("record") TopologyAutoProjectAppRel record, @Param("example") TopologyAutoProjectAppRelExample example);

    int updateByExample(@Param("record") TopologyAutoProjectAppRel record, @Param("example") TopologyAutoProjectAppRelExample example);
}