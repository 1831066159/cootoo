package cn.com.cootoo.controller;

import cn.com.cootoo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhaoxiang
 * @create 2018/9/29
 **/

@Controller
@RequestMapping("/page")
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);


    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/header")
    public String getHeader() {
        logger.info("this is header...");
        return "this is header...";
    }

    @RequestMapping("/test")
    public ModelAndView mytest() {
        logger.info("test.........");
        userService.addUser();
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan11111111");
        mode.setViewName("page/test");
        return mode;
    }

    @ResponseBody
    @RequestMapping(value = "/index")
    public ModelAndView goHome() {
        logger.info("go to the home page!");
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan11111111");
        mode.setViewName("hello");
        return mode;
    }


}
