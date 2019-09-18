package cn.com.cootoo.demo.neo4j.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Configuration
@EnableNeo4jRepositories(basePackages = "cn.com.cootoo.demo.neo4j.reporsitory")
@EntityScan(basePackages = "cn.com.cootoo.demo.neo4j.node")
@EnableTransactionManagement
public class Neo4jConfig {
}
