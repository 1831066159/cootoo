package cn.com.cootoo.graph.service;

import cn.com.cootoo.graph.dao.bizz.risk.LoanDAO;
import cn.com.cootoo.graph.dao.neo4j.repository.UserLoanRelationRepository;
import cn.com.cootoo.graph.model.bizz.risk.Loan;
import cn.com.cootoo.graph.model.neo4j.node.LoanInfo;
import cn.com.cootoo.graph.model.neo4j.node.UserInfo;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author system
 * @create 2019/9/29
 **/
@Slf4j
@Service
public abstract class BaseService {


    @Autowired
    private UserLoanRelationRepository userLoanRelationDAO;


    @Autowired
    private LoanDAO loanExtDAO;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    @Qualifier("riskMongoTemplate")
    private MongoTemplate riskMongoTemplate;

    @Autowired
    @Qualifier("xiaohuMongoTemplate")
    private MongoTemplate xiaohuMongoTemplate;


    public void execute() {

        String loanid = "";
        Loan loan = loanExtDAO.getByLoanId(loanid);


        // 用户基本信息
        JSONObject userBaseInfo = riskMongoTemplate.findOne(new Query(Criteria.where("loanId").is(loanid)), JSONObject.class, "userBaseInfo");


        // 用户借款需求
        JSONObject loanRequireInfo = riskMongoTemplate.findOne(new Query(Criteria.where("loanId").is(loanid)), JSONObject.class, "loanRequireInfo");

        // 用户职业信息
        JSONObject userProfessionInfo = riskMongoTemplate.findOne(new Query(Criteria.where("loanId").is(loanid)), JSONObject.class, "userProfessionInfo");

        // 设备信息
        JSONObject equipmentInfo = riskMongoTemplate.findOne(new Query(Criteria.where("loanId").is(loanid)), JSONObject.class, "equipmentInfo");


        LoanInfo loanInfo = new LoanInfo();
        loanInfo.setLoan_id(Long.parseLong(loanid));
        loanInfo.setBiz_name("");
        loanInfo.setBiz_status_name(loan.getBizStatusName());


        UserInfo userInfo = new UserInfo();
        userInfo.setId_card_no(loan.getIdCardNo());
        userInfo.setUser_name(loan.getBorrowerName());

    }

    /**
     * 证件号关系
     * 1-订单号和证件号之间的关系
     * 2-证件号和设备号之间的关系
     * 3-证件号和GPS之间的关系
     * 4-证件号和电话号之间的关系
     * 5-申请人手机号和其他手机号之间的关系
     * 6-证件号与登陆ip关系
     * 7-证件号与放款银行卡号关系
     * 8-证件号与地址关系
     * 9-证件号与学校关系
     * 10-证件号房屋关系
     */
    public void baseRelations() {


    }


    /**
     * http://doc.soydai.me/pages/viewpage.action?pageId=19628278
     */
    public void userInfo() {

    }
}
