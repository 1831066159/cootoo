package cn.com.cootoo.demo.neo4j;

import cn.com.cootoo.demo.neo4j.node.Loan;
import cn.com.cootoo.demo.neo4j.reporsitory.LoanReporsitory;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Slf4j
@Service
public class GraphService {

    @Autowired
    private LoanReporsitory loanReporsitory;


    public void getLoan() {
        List<Loan> list = loanReporsitory.getLoans();

        for (Loan obj : list) {
            System.out.println(JSON.toJSONString(obj));
        }
    }

}
