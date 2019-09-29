package cn.com.cootoo.graph.dao.neo4j.repository;


import cn.com.cootoo.graph.model.neo4j.relation.UserLoanRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Component
public interface UserLoanRelationRepository extends Neo4jRepository<UserLoanRelation, Long> {


}
