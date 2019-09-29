package cn.com.cootoo.graph.model.bizz.risk;


import lombok.Data;

@Data
public class Loan {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long loanId;
    /**
     * 业务流水号，
     */
    private String processInstanceId;
    /**
     * 进件系统编码
     */
    private String systemCode;
    /**
     * 进件系统请求id
     */
    private String requestId;
    /**
     * 平台标的标识（在p2p业务中对应这标id，在保理业务中对应着资产id）
     */
    private Long bidid;
    /**
     * 资产管理方式 1.p2p 2.保理
     */
    private Integer assetMode;
    /**
     * 产品类型
     */
    private Integer loanType;
    /**
     *
     */
    private String loanTypeName;
    /**
     * 消息请求类型
     */
    private String msgType;
    /**
     * 还款方式
     */
    private Integer repayMethod;
    /**
     *
     */
    private String repayMethodName;
    /**
     * 期限
     */
    private Integer term;
    /**
     * 借款周期单位1月，2日，3年
     */
    private Integer borrowperiodunit;
    /**
     * 借款金额
     */
    private Long loanAmount;
    /**
     * 平台用户id
     */
    private String userId;
    /**
     * 借款人姓名
     */
    private String borrowerName;
    /**
     * 兼容VALUE的md5值
     */
    private String idCardNo;
    /**
     * 兼容VALUE的md5值
     */
    private String moblie;
    /**
     *
     */
    private java.util.Date comeTime;
    /**
     * 来源
     */
    private Integer sourceId;
    /**
     *
     */
    private String sourceName;
    /**
     * 更新时间
     */
    private java.util.Date timestamp;
    /**
     * 业务类型编码
     */
    private String bizCode;
    /**
     * 业务类型名称
     */
    private String bizName;
    /**
     * 业务状态
     */
    private Integer bizStatus;
    /**
     * 业务状态
     */
    private String bizStatusName;
    /**
     * 中间状态 0:无
     */
    private Integer middleStatus;
    /**
     * 中间状态 无
     */
    private String middleStatusName;
    /**
     * 贷后状态
     */
    private Integer afterStatus;
    /**
     * 贷后状态
     */
    private String afterStatusName;
    /**
     * 放款日期
     */
    private java.util.Date grantTime;
    /**
     * 放款金额
     */
    private Long grantAmount;
    /**
     * 放弃理由
     */
    private String quitReason;
    /**
     * 放弃理由描述
     */
    private String quitDes;
    /**
     * mId
     */
    private Long mid;
    /**
     * 进件城市code 取自bs：apply_city_house
     */
    private String loanCityCode;

}