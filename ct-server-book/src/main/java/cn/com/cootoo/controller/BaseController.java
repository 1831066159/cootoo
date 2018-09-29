package cn.com.cootoo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxiang
 * @create 2018/9/29
 **/

@RestController
@RequestMapping("/base")
public class BaseController {


    @RequestMapping("/header")
    public String getHeader() {
        return "this is header...";
    }

}
