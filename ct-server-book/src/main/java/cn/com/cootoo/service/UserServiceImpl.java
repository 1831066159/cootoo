package cn.com.cootoo.service;

import cn.com.cootoo.mapper.UserMapper;
import cn.com.cootoo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiang
 * @create 2018/10/15
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser() {
        User user = new User();
//        user.setUserId(123);
        user.setPhone("99999");
        user.setPassword("123");
        user.setUserName("test");
        int i = userMapper.insert(user);
        System.out.println("insert success: " + i);
    }
}
