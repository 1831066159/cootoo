package cn.com.cootoo.graph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * springcloud的注册中心
 * @author Administrator
 * 启动后，在浏览器通过 localhost:8888访问
 */
@EnableEurekaServer
@SpringBootApplication
public class CtEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtEurekaServerApplication.class, args);
	}
}
