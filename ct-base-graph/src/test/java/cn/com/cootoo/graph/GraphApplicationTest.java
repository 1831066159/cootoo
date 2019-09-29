package cn.com.cootoo.graph; 

import cn.com.cootoo.graph.dao.neo4j.repository.UserInfoRepository;
import cn.com.cootoo.graph.model.neo4j.node.UserInfo;
import cn.com.cootoo.graph.service.LoanInfoService;
import cn.com.cootoo.graph.service.UserInfoService;
import cn.com.cootoo.graph.service.UserLoanRelationService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* GraphApplication Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 29, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GraphApplication.class})
public class GraphApplicationTest {

    @Autowired
    private LoanInfoService loanInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserLoanRelationService userLoanRelationService;

    @Autowired
    private UserInfoRepository userInfoRepository;




    @Test
    public void getbyparam() {
        //addressService.getByaddress("这是测试_31");
        loanInfoService.findArea(2090L, 2099L);
    }


    @Test
    public void addLoan() throws InterruptedException {
        loanInfoService.addMulity(1000);
        Thread.sleep(5000l);
        loanInfoService.getObj();
    }


    @Test
    public void addUser() throws InterruptedException {
        userInfoService.addMulity(10000);
        Thread.sleep(5000l);
        userInfoService.getObj();
    }

    @Test
    public void addRelation() throws InterruptedException {
        userLoanRelationService.addRelation();
        Thread.sleep(5000l);
        userLoanRelationService.getObj();
    }


    @Test
    public void testQuery() {
        List<UserInfo> userInfoList = userInfoRepository.findPart(50);
        userInfoList.forEach(userInfo -> {
            System.out.println(userInfo.toString());
        });
    }

} 
