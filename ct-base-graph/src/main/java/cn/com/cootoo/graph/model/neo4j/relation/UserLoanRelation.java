package cn.com.cootoo.graph.model.neo4j.relation;


import cn.com.cootoo.graph.constant.EasyRelationType;
import cn.com.cootoo.graph.model.neo4j.base.BaseRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * @author system
 * @create 2019/9/11
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@RelationshipEntity(type = EasyRelationType.USER_LOAN)
public class UserLoanRelation extends BaseRelation {


    /**
     * 如果id_card_no为申请人，则'purpose'='申请'，如果为共贷人，则'purpose'= '共贷'，如果为担保人，则'purpose'= '担保'
     */
    @Property
    private String purpose;
}
