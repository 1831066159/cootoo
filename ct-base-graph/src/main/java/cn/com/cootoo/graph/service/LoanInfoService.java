package cn.com.cootoo.graph.service;

import cn.com.cootoo.graph.dao.neo4j.repository.LoanInfoRepository;
import cn.com.cootoo.graph.model.neo4j.node.LoanInfo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Slf4j
@Service
public class LoanInfoService {


    @Autowired
    private LoanInfoRepository loanInfoRepository;


    public void query() {

    }


    public void deleteAll() {
        loanInfoRepository.deleteAll();

    }

    public void findArea(Long start, Long end) {
        List<LoanInfo> list = loanInfoRepository.findArea(start, end);

        for (LoanInfo ss : list) {
            System.out.println(JSON.toJSONString(ss));
        }
    }

    public void getObj() {

        System.out.println("=========getboj======");
        Iterable<LoanInfo> list = loanInfoRepository.findAll(1);

        list.forEach(address -> {
            System.out.print(JSON.toJSON(address));
        });

    }

    public void getOne() {
        Optional<LoanInfo> optional = loanInfoRepository.findById(9389443L);

        LoanInfo ads = optional.get();
        System.out.println(JSON.toJSONString(ads));
    }

    public void addone() {
        LoanInfo loan = new LoanInfo();
        loan.setLoan_id(100000L);
        loan.setBiz_name("");
        loan.setReview_status("");
        loan.setMax_over_days(20);
        loan.setBiz_status_name("");
        LoanInfo s = loanInfoRepository.save(loan);
        System.out.println(s.toString());
    }


    public void addMulity(int no) {
        List<LoanInfo> list = new ArrayList<>();
        for (int i = 0; i <= no; i++) {
            LoanInfo loan = new LoanInfo();
            Long id = 20190920000L + i;
            loan.setLoan_id(id);
            loan.setBiz_name("bizName_" + i);
            loan.setReview_status("rs");
            loan.setMax_over_days(20);
            loan.setBiz_status_name("bizSName_" + i);
            list.add(loan);
        }
        System.out.println("-------- save nodes");
        try {
            Iterable<LoanInfo> res = loanInfoRepository.saveAll(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("批量保存完成");
    }


}
