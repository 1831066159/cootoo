package cn.com.cootoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@EnableAutoConfiguration
@SpringBootApplication
@Controller
@EnableZuulProxy
public class CtGatewayApplication extends SpringBootServletInitializer {

    private static Logger logger = LoggerFactory.getLogger(CtGatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CtGatewayApplication.class, args);
        logger.info("***>>>>>>>Server startup>>>");
    }

}
