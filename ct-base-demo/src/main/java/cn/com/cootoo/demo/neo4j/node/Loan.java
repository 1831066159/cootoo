package cn.com.cootoo.demo.neo4j.node;

import lombok.Getter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author zhaoxiang
 * @create 2019/9/11
 **/
@Getter
@NodeEntity(label = "Loan")
public class Loan {

    @GraphId
    private Long id;

    @Property
    private int loan_id;

    @Property
    private String biz_name;

    @Property
    private String biz_status_name;

}
