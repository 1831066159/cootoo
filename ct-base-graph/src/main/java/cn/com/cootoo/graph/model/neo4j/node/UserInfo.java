package cn.com.cootoo.graph.model.neo4j.node;


import cn.com.cootoo.graph.constant.EasyNodeType;
import cn.com.cootoo.graph.model.neo4j.base.BaseNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * 用户基本信息
 *
 * @author system
 * @create 2019/9/19
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@NodeEntity(label = EasyNodeType.USER)
public class UserInfo extends BaseNode {


    @Property
    private String user_name;

    @Property
    private String id_card_no;

    @Property
    private String mobile;

    /**
     * 性别
     */
    @Property
    private String sex;

    /**
     * 出生日期 yyyyMMdd
     */
    @Property
    private String birthDay;

    /**
     * 婚姻状况
     */
    @Property
    private String marrSign;

    /**
     * 学历
     */
    @Property
    private String educSign;


}
