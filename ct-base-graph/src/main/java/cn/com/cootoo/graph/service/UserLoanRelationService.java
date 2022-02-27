package cn.com.cootoo.graph.service;

import cn.com.cootoo.graph.dao.neo4j.repository.LoanInfoRepository;
import cn.com.cootoo.graph.dao.neo4j.repository.UserInfoRepository;
import cn.com.cootoo.graph.dao.neo4j.repository.UserLoanRelationRepository;
import cn.com.cootoo.graph.model.neo4j.node.LoanInfo;
import cn.com.cootoo.graph.model.neo4j.node.UserInfo;
import cn.com.cootoo.graph.model.neo4j.relation.UserLoanRelation;
import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author system
 * @create 2019/9/20
 **/
@Service
public class UserLoanRelationService {

      @Autowired
    private UserLoanRelationRepository userLoanRelationDAO;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private LoanInfoRepository loanInfoRepository;


    public void addRelation() {
        Long start = 20190920000L;
        Long end = 20190920010L;
        List<UserLoanRelation> relationList = new ArrayList<>();
        List<UserInfo> userInfoList = userInfoRepository.findPart(50);
        for (UserInfo user : userInfoList) {

            List<LoanInfo> loanInfos = loanInfoRepository.findArea(start, end);
            for (LoanInfo loanInfo : loanInfos) {
                UserLoanRelation relation = new UserLoanRelation();
                relation.setStart(user);
                relation.setEnd(loanInfo);
                relationList.add(relation);
            }

            start = end;
            end = end + 10;
        }

        System.out.println("-------- save all relation");
        try {
            Iterable<UserLoanRelation> res = userLoanRelationDAO.saveAll(relationList);
//            res.forEach(userInfo -> {
//                System.out.println(userInfo.toString());
//            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("批量保存完成");
    }


    public void getObj() {

        System.out.println("=========getboj======");
        Iterable<UserLoanRelation> list = userLoanRelationDAO.findAll(1);

        list.forEach(address -> {
            System.out.print(JSON.toJSON(address));
        });

    }
}
