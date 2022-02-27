package cn.com.cootoo.graph.service;

import cn.com.cootoo.graph.dao.neo4j.repository.UserInfoRepository;
import cn.com.cootoo.graph.model.neo4j.node.UserInfo;
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
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    public void add(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    public void addMulity(int no) {
        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i <= no; i++) {
            UserInfo userInfo = new UserInfo();
            Long id = 6000L + i;
            userInfo.setUser_name("帅哥_" + i);
            userInfo.setId_card_no("ID_" + i);
            list.add(userInfo);
        }
        System.out.println("-------- save nodes");
        try {
            Iterable<UserInfo> res = userInfoRepository.saveAll(list);

            res.forEach(userInfo -> {
                System.out.println(userInfo.toString());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("-------- save relation");
        // relationRepository.saveAll(relations);

        System.out.println("批量保存完成");
    }


    public void getObj() {

        System.out.println("=========getboj======");
        Iterable<UserInfo> list = userInfoRepository.findAll(1);

        list.forEach(address -> {
            System.out.print(JSON.toJSON(address));
        });

    }
}
