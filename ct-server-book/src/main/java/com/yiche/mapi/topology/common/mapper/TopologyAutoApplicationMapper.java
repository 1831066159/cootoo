package com.cootoo.mapi.topology.common.mapper;

import com.cootoo.mapi.topology.common.entity.TopologyAutoApplication;
import com.cootoo.mapi.topology.common.entity.TopologyAutoApplicationExample;
import org.apache.ibatis.annotations.Param;

public interface TopologyAutoApplicationMapper {
    long countByExample(TopologyAutoApplicationExample example);

    int deleteByExample(TopologyAutoApplicationExample example);

    int insert(TopologyAutoApplication record);

    int insertSelective(TopologyAutoApplication record);

    int updateByExampleSelective(@Param("record") TopologyAutoApplication record, @Param("example") TopologyAutoApplicationExample example);

    int updateByExample(@Param("record") TopologyAutoApplication record, @Param("example") TopologyAutoApplicationExample example);
}