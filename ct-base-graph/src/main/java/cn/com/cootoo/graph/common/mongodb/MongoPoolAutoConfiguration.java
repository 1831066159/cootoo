package cn.com.cootoo.graph.common.mongodb;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 配置Mongodb数据库连接池信息
 *
 * @author zhaoxiang
 * @create 2019/9/27
 **/
@Configuration
@Component
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class MongoPoolAutoConfiguration {

    @Bean
    public MongoPoolInit mongoPoolInit() {
        return new MongoPoolInit();
    }

}
