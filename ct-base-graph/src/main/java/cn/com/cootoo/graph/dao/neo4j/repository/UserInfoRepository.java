package cn.com.cootoo.graph.dao.neo4j.repository;


import cn.com.cootoo.graph.model.neo4j.node.UserInfo;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Component
public interface UserInfoRepository extends Neo4jRepository<UserInfo, Long> {


    /**
     * @return
     */
    @Query("MATCH (n:summ_user) where n.user_name={uname} return n")
    UserInfo findByUname(@Param("uname") String uname);

    /**
     * @return
     */
    @Query("MATCH (n:summ_user) RETURN n LIMIT {limit}")
    List<UserInfo> findPart(@Param("limit") int limit);


    /**
     * @return
     */
    @Query("match(n:summ_user) where n.id >{start} and n.id<{end} return n")
    List<UserInfo> findArea(@Param("start") int start, @Param("end") int end);




}
