package cn.com.cootoo.graph.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * neo4j配置
 *
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Configuration
@EnableNeo4jRepositories(basePackages = "com.huli.risk.graph.dao.neo4j.repository")
@EntityScan(basePackages = "com.huli.risk.graph.model.neo4j")
@EnableTransactionManagement
public class GraphDBConfiguration {

}
