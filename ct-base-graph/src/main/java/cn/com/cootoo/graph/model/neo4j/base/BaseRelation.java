package cn.com.cootoo.graph.model.neo4j.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

/**
 * 关系基类
 *
 * @author system
 * @create 2019/9/24
 **/
@Data
@NoArgsConstructor
public class BaseRelation<S extends BaseNode, E extends BaseNode> {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;

    @Property
    private String create_time;

    @JsonIgnore
    @StartNode
    private S start;

    @JsonIgnore
    @EndNode
    private E end;


}
