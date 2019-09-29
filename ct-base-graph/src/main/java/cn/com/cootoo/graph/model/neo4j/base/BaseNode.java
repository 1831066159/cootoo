package cn.com.cootoo.graph.model.neo4j.base;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 节点基类
 *
 * @author zhaoxiang
 * @create 2019/9/24
 **/
public abstract class BaseNode {

    @Id
    @GeneratedValue
    private Long id;

    @DateString
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time = new Date();

}
