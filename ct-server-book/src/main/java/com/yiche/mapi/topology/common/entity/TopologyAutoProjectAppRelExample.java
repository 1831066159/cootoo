package com.cootoo.mapi.topology.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopologyAutoProjectAppRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopologyAutoProjectAppRelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTLeftIdIsNull() {
            addCriterion("t_left_id is null");
            return (Criteria) this;
        }

        public Criteria andTLeftIdIsNotNull() {
            addCriterion("t_left_id is not null");
            return (Criteria) this;
        }

        public Criteria andTLeftIdEqualTo(Long value) {
            addCriterion("t_left_id =", value, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdNotEqualTo(Long value) {
            addCriterion("t_left_id <>", value, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdGreaterThan(Long value) {
            addCriterion("t_left_id >", value, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdGreaterThanOrEqualTo(Long value) {
            addCriterion("t_left_id >=", value, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdLessThan(Long value) {
            addCriterion("t_left_id <", value, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdLessThanOrEqualTo(Long value) {
            addCriterion("t_left_id <=", value, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdIn(List<Long> values) {
            addCriterion("t_left_id in", values, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdNotIn(List<Long> values) {
            addCriterion("t_left_id not in", values, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdBetween(Long value1, Long value2) {
            addCriterion("t_left_id between", value1, value2, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftIdNotBetween(Long value1, Long value2) {
            addCriterion("t_left_id not between", value1, value2, "tLeftId");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeIsNull() {
            addCriterion("t_left_type is null");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeIsNotNull() {
            addCriterion("t_left_type is not null");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeEqualTo(Byte value) {
            addCriterion("t_left_type =", value, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeNotEqualTo(Byte value) {
            addCriterion("t_left_type <>", value, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeGreaterThan(Byte value) {
            addCriterion("t_left_type >", value, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("t_left_type >=", value, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeLessThan(Byte value) {
            addCriterion("t_left_type <", value, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeLessThanOrEqualTo(Byte value) {
            addCriterion("t_left_type <=", value, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeIn(List<Byte> values) {
            addCriterion("t_left_type in", values, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeNotIn(List<Byte> values) {
            addCriterion("t_left_type not in", values, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeBetween(Byte value1, Byte value2) {
            addCriterion("t_left_type between", value1, value2, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTLeftTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("t_left_type not between", value1, value2, "tLeftType");
            return (Criteria) this;
        }

        public Criteria andTRightIdIsNull() {
            addCriterion("t_right_id is null");
            return (Criteria) this;
        }

        public Criteria andTRightIdIsNotNull() {
            addCriterion("t_right_id is not null");
            return (Criteria) this;
        }

        public Criteria andTRightIdEqualTo(Long value) {
            addCriterion("t_right_id =", value, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdNotEqualTo(Long value) {
            addCriterion("t_right_id <>", value, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdGreaterThan(Long value) {
            addCriterion("t_right_id >", value, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdGreaterThanOrEqualTo(Long value) {
            addCriterion("t_right_id >=", value, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdLessThan(Long value) {
            addCriterion("t_right_id <", value, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdLessThanOrEqualTo(Long value) {
            addCriterion("t_right_id <=", value, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdIn(List<Long> values) {
            addCriterion("t_right_id in", values, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdNotIn(List<Long> values) {
            addCriterion("t_right_id not in", values, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdBetween(Long value1, Long value2) {
            addCriterion("t_right_id between", value1, value2, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightIdNotBetween(Long value1, Long value2) {
            addCriterion("t_right_id not between", value1, value2, "tRightId");
            return (Criteria) this;
        }

        public Criteria andTRightTypeIsNull() {
            addCriterion("t_right_type is null");
            return (Criteria) this;
        }

        public Criteria andTRightTypeIsNotNull() {
            addCriterion("t_right_type is not null");
            return (Criteria) this;
        }

        public Criteria andTRightTypeEqualTo(Byte value) {
            addCriterion("t_right_type =", value, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeNotEqualTo(Byte value) {
            addCriterion("t_right_type <>", value, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeGreaterThan(Byte value) {
            addCriterion("t_right_type >", value, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("t_right_type >=", value, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeLessThan(Byte value) {
            addCriterion("t_right_type <", value, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeLessThanOrEqualTo(Byte value) {
            addCriterion("t_right_type <=", value, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeIn(List<Byte> values) {
            addCriterion("t_right_type in", values, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeNotIn(List<Byte> values) {
            addCriterion("t_right_type not in", values, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeBetween(Byte value1, Byte value2) {
            addCriterion("t_right_type between", value1, value2, "tRightType");
            return (Criteria) this;
        }

        public Criteria andTRightTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("t_right_type not between", value1, value2, "tRightType");
            return (Criteria) this;
        }

        public Criteria andThroughputIsNull() {
            addCriterion("throughput is null");
            return (Criteria) this;
        }

        public Criteria andThroughputIsNotNull() {
            addCriterion("throughput is not null");
            return (Criteria) this;
        }

        public Criteria andThroughputEqualTo(Long value) {
            addCriterion("throughput =", value, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputNotEqualTo(Long value) {
            addCriterion("throughput <>", value, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputGreaterThan(Long value) {
            addCriterion("throughput >", value, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputGreaterThanOrEqualTo(Long value) {
            addCriterion("throughput >=", value, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputLessThan(Long value) {
            addCriterion("throughput <", value, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputLessThanOrEqualTo(Long value) {
            addCriterion("throughput <=", value, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputIn(List<Long> values) {
            addCriterion("throughput in", values, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputNotIn(List<Long> values) {
            addCriterion("throughput not in", values, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputBetween(Long value1, Long value2) {
            addCriterion("throughput between", value1, value2, "throughput");
            return (Criteria) this;
        }

        public Criteria andThroughputNotBetween(Long value1, Long value2) {
            addCriterion("throughput not between", value1, value2, "throughput");
            return (Criteria) this;
        }

        public Criteria andItimeIsNull() {
            addCriterion("itime is null");
            return (Criteria) this;
        }

        public Criteria andItimeIsNotNull() {
            addCriterion("itime is not null");
            return (Criteria) this;
        }

        public Criteria andItimeEqualTo(String value) {
            addCriterion("itime =", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotEqualTo(String value) {
            addCriterion("itime <>", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeGreaterThan(String value) {
            addCriterion("itime >", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeGreaterThanOrEqualTo(String value) {
            addCriterion("itime >=", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeLessThan(String value) {
            addCriterion("itime <", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeLessThanOrEqualTo(String value) {
            addCriterion("itime <=", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeLike(String value) {
            addCriterion("itime like", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotLike(String value) {
            addCriterion("itime not like", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeIn(List<String> values) {
            addCriterion("itime in", values, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotIn(List<String> values) {
            addCriterion("itime not in", values, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeBetween(String value1, String value2) {
            addCriterion("itime between", value1, value2, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotBetween(String value1, String value2) {
            addCriterion("itime not between", value1, value2, "itime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}