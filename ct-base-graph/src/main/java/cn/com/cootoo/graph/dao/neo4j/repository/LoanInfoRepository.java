package cn.com.cootoo.graph.dao.neo4j.repository;


import cn.com.cootoo.graph.model.neo4j.node.LoanInfo;
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
public interface LoanInfoRepository extends Neo4jRepository<LoanInfo, Long> {

    /**
     * @return
     */
    @Query("MATCH (n:summ_loan) where n.loan_id={loanid} return n")
    LoanInfo findByLoanid(@Param("loanid") String loanid);

    /**
     * @return
     */
    @Query("MATCH (n:summ_loan) RETURN n LIMIT {limit}")
    List<LoanInfo> findPart(@Param("limit") int limit);

    /**
     * @return
     */
    @Query("MATCH (n:summ_loan) where n.loan_id>{start} and n.loan_id<{end} return n")
    List<LoanInfo> findArea(@Param("start") Long start, @Param("end") Long end);

}
