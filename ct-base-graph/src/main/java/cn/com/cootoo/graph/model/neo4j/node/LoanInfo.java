package cn.com.cootoo.graph.model.neo4j.node;


import cn.com.cootoo.graph.constant.EasyNodeType;
import cn.com.cootoo.graph.model.neo4j.base.BaseNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author zhaoxiang
 * @create 2019/9/19
 * <p>
 * 1、'review_status'  字段处理： '通过' if ‘biz_status_name’ in ('已结清', '审核通过', '已逾期', '还款中', '放标中') else ('拒绝' if  ‘biz_status_name’ in ('审核拒绝') else '其它'))；
 * 2、'max_over_days'  字段处理：  一个loanid存在多个'max_over_days'，取最大的一个数值，
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = EasyNodeType.LOAN)
public class LoanInfo extends BaseNode {

    @Property
    private Long loan_id;

    /**
     * 务类型名称
     */
    @Property
    private String biz_name;

    /**
     *
     */
    @Property
    private String review_status;

    /**
     * 业务状态名
     */
    @Property
    private String biz_status_name;

    /**
     * 最大逾期天数
     */
    @Property
    private int max_over_days;


}
