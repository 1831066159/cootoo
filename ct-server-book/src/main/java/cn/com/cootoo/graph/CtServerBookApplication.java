package cn.com.cootoo.graph;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("cn.com.cootoo.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class CtServerBookApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(CtServerBookApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CtServerBookApplication.class);
    }
}
