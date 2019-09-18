package cn.com.cootoo.demo.neo4j.reporsitory;

import cn.com.cootoo.demo.neo4j.node.Loan;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Repository
public interface LoanReporsitory extends Neo4jRepository<Loan, Long> {


    @Query("MATCH (n:loan_id) RETURN n LIMIT 25")
    List<Loan> getLoans();

}
