package cn.com.cootoo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoxiang
 * @create 2019/8/16
 **/
@Controller
@RequestMapping("/base")
public class BaseController {

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);


    @ResponseBody
    @RequestMapping(value = "/index")
    public String goHome() {
        logger.info("index......");

        return "111111";
    }
}


