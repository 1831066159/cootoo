package com.cootoo.mapi.topology.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopologyAutoApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopologyAutoApplicationExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNull() {
            addCriterion("application_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNotNull() {
            addCriterion("application_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameEqualTo(String value) {
            addCriterion("application_name =", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotEqualTo(String value) {
            addCriterion("application_name <>", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThan(String value) {
            addCriterion("application_name >", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThanOrEqualTo(String value) {
            addCriterion("application_name >=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThan(String value) {
            addCriterion("application_name <", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThanOrEqualTo(String value) {
            addCriterion("application_name <=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLike(String value) {
            addCriterion("application_name like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotLike(String value) {
            addCriterion("application_name not like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIn(List<String> values) {
            addCriterion("application_name in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotIn(List<String> values) {
            addCriterion("application_name not in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameBetween(String value1, String value2) {
            addCriterion("application_name between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotBetween(String value1, String value2) {
            addCriterion("application_name not between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNull() {
            addCriterion("application_type is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNotNull() {
            addCriterion("application_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeEqualTo(Integer value) {
            addCriterion("application_type =", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotEqualTo(Integer value) {
            addCriterion("application_type <>", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThan(Integer value) {
            addCriterion("application_type >", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_type >=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThan(Integer value) {
            addCriterion("application_type <", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("application_type <=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIn(List<Integer> values) {
            addCriterion("application_type in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotIn(List<Integer> values) {
            addCriterion("application_type not in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeBetween(Integer value1, Integer value2) {
            addCriterion("application_type between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("application_type not between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlIsNull() {
            addCriterion("application_url is null");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlIsNotNull() {
            addCriterion("application_url is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlEqualTo(String value) {
            addCriterion("application_url =", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlNotEqualTo(String value) {
            addCriterion("application_url <>", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlGreaterThan(String value) {
            addCriterion("application_url >", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlGreaterThanOrEqualTo(String value) {
            addCriterion("application_url >=", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlLessThan(String value) {
            addCriterion("application_url <", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlLessThanOrEqualTo(String value) {
            addCriterion("application_url <=", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlLike(String value) {
            addCriterion("application_url like", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlNotLike(String value) {
            addCriterion("application_url not like", value, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlIn(List<String> values) {
            addCriterion("application_url in", values, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlNotIn(List<String> values) {
            addCriterion("application_url not in", values, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlBetween(String value1, String value2) {
            addCriterion("application_url between", value1, value2, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationUrlNotBetween(String value1, String value2) {
            addCriterion("application_url not between", value1, value2, "applicationUrl");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerIsNull() {
            addCriterion("application_owner is null");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerIsNotNull() {
            addCriterion("application_owner is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerEqualTo(String value) {
            addCriterion("application_owner =", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerNotEqualTo(String value) {
            addCriterion("application_owner <>", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerGreaterThan(String value) {
            addCriterion("application_owner >", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("application_owner >=", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerLessThan(String value) {
            addCriterion("application_owner <", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerLessThanOrEqualTo(String value) {
            addCriterion("application_owner <=", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerLike(String value) {
            addCriterion("application_owner like", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerNotLike(String value) {
            addCriterion("application_owner not like", value, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerIn(List<String> values) {
            addCriterion("application_owner in", values, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerNotIn(List<String> values) {
            addCriterion("application_owner not in", values, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerBetween(String value1, String value2) {
            addCriterion("application_owner between", value1, value2, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationOwnerNotBetween(String value1, String value2) {
            addCriterion("application_owner not between", value1, value2, "applicationOwner");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionIsNull() {
            addCriterion("application_version is null");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionIsNotNull() {
            addCriterion("application_version is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionEqualTo(String value) {
            addCriterion("application_version =", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionNotEqualTo(String value) {
            addCriterion("application_version <>", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionGreaterThan(String value) {
            addCriterion("application_version >", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionGreaterThanOrEqualTo(String value) {
            addCriterion("application_version >=", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionLessThan(String value) {
            addCriterion("application_version <", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionLessThanOrEqualTo(String value) {
            addCriterion("application_version <=", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionLike(String value) {
            addCriterion("application_version like", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionNotLike(String value) {
            addCriterion("application_version not like", value, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionIn(List<String> values) {
            addCriterion("application_version in", values, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionNotIn(List<String> values) {
            addCriterion("application_version not in", values, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionBetween(String value1, String value2) {
            addCriterion("application_version between", value1, value2, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andApplicationVersionNotBetween(String value1, String value2) {
            addCriterion("application_version not between", value1, value2, "applicationVersion");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andIsHideIsNull() {
            addCriterion("is_hide is null");
            return (Criteria) this;
        }

        public Criteria andIsHideIsNotNull() {
            addCriterion("is_hide is not null");
            return (Criteria) this;
        }

        public Criteria andIsHideEqualTo(Byte value) {
            addCriterion("is_hide =", value, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideNotEqualTo(Byte value) {
            addCriterion("is_hide <>", value, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideGreaterThan(Byte value) {
            addCriterion("is_hide >", value, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_hide >=", value, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideLessThan(Byte value) {
            addCriterion("is_hide <", value, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideLessThanOrEqualTo(Byte value) {
            addCriterion("is_hide <=", value, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideIn(List<Byte> values) {
            addCriterion("is_hide in", values, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideNotIn(List<Byte> values) {
            addCriterion("is_hide not in", values, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideBetween(Byte value1, Byte value2) {
            addCriterion("is_hide between", value1, value2, "isHide");
            return (Criteria) this;
        }

        public Criteria andIsHideNotBetween(Byte value1, Byte value2) {
            addCriterion("is_hide not between", value1, value2, "isHide");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andInstanceCountIsNull() {
            addCriterion("instance_count is null");
            return (Criteria) this;
        }

        public Criteria andInstanceCountIsNotNull() {
            addCriterion("instance_count is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceCountEqualTo(Short value) {
            addCriterion("instance_count =", value, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountNotEqualTo(Short value) {
            addCriterion("instance_count <>", value, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountGreaterThan(Short value) {
            addCriterion("instance_count >", value, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountGreaterThanOrEqualTo(Short value) {
            addCriterion("instance_count >=", value, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountLessThan(Short value) {
            addCriterion("instance_count <", value, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountLessThanOrEqualTo(Short value) {
            addCriterion("instance_count <=", value, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountIn(List<Short> values) {
            addCriterion("instance_count in", values, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountNotIn(List<Short> values) {
            addCriterion("instance_count not in", values, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountBetween(Short value1, Short value2) {
            addCriterion("instance_count between", value1, value2, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceCountNotBetween(Short value1, Short value2) {
            addCriterion("instance_count not between", value1, value2, "instanceCount");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusIsNull() {
            addCriterion("instance_status is null");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusIsNotNull() {
            addCriterion("instance_status is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusEqualTo(Byte value) {
            addCriterion("instance_status =", value, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusNotEqualTo(Byte value) {
            addCriterion("instance_status <>", value, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusGreaterThan(Byte value) {
            addCriterion("instance_status >", value, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("instance_status >=", value, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusLessThan(Byte value) {
            addCriterion("instance_status <", value, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("instance_status <=", value, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusIn(List<Byte> values) {
            addCriterion("instance_status in", values, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusNotIn(List<Byte> values) {
            addCriterion("instance_status not in", values, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusBetween(Byte value1, Byte value2) {
            addCriterion("instance_status between", value1, value2, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("instance_status not between", value1, value2, "instanceStatus");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailIsNull() {
            addCriterion("instance_status_detail is null");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailIsNotNull() {
            addCriterion("instance_status_detail is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailEqualTo(String value) {
            addCriterion("instance_status_detail =", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailNotEqualTo(String value) {
            addCriterion("instance_status_detail <>", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailGreaterThan(String value) {
            addCriterion("instance_status_detail >", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailGreaterThanOrEqualTo(String value) {
            addCriterion("instance_status_detail >=", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailLessThan(String value) {
            addCriterion("instance_status_detail <", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailLessThanOrEqualTo(String value) {
            addCriterion("instance_status_detail <=", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailLike(String value) {
            addCriterion("instance_status_detail like", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailNotLike(String value) {
            addCriterion("instance_status_detail not like", value, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailIn(List<String> values) {
            addCriterion("instance_status_detail in", values, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailNotIn(List<String> values) {
            addCriterion("instance_status_detail not in", values, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailBetween(String value1, String value2) {
            addCriterion("instance_status_detail between", value1, value2, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andInstanceStatusDetailNotBetween(String value1, String value2) {
            addCriterion("instance_status_detail not between", value1, value2, "instanceStatusDetail");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andAnameIsNull() {
            addCriterion("aname is null");
            return (Criteria) this;
        }

        public Criteria andAnameIsNotNull() {
            addCriterion("aname is not null");
            return (Criteria) this;
        }

        public Criteria andAnameEqualTo(Integer value) {
            addCriterion("aname =", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotEqualTo(Integer value) {
            addCriterion("aname <>", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThan(Integer value) {
            addCriterion("aname >", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThanOrEqualTo(Integer value) {
            addCriterion("aname >=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThan(Integer value) {
            addCriterion("aname <", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThanOrEqualTo(Integer value) {
            addCriterion("aname <=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameIn(List<Integer> values) {
            addCriterion("aname in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotIn(List<Integer> values) {
            addCriterion("aname not in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameBetween(Integer value1, Integer value2) {
            addCriterion("aname between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotBetween(Integer value1, Integer value2) {
            addCriterion("aname not between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
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

        public Criteria andModifyByIsNull() {
            addCriterion("modify_by is null");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNotNull() {
            addCriterion("modify_by is not null");
            return (Criteria) this;
        }

        public Criteria andModifyByEqualTo(String value) {
            addCriterion("modify_by =", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotEqualTo(String value) {
            addCriterion("modify_by <>", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThan(String value) {
            addCriterion("modify_by >", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThanOrEqualTo(String value) {
            addCriterion("modify_by >=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThan(String value) {
            addCriterion("modify_by <", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThanOrEqualTo(String value) {
            addCriterion("modify_by <=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLike(String value) {
            addCriterion("modify_by like", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotLike(String value) {
            addCriterion("modify_by not like", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByIn(List<String> values) {
            addCriterion("modify_by in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotIn(List<String> values) {
            addCriterion("modify_by not in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByBetween(String value1, String value2) {
            addCriterion("modify_by between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotBetween(String value1, String value2) {
            addCriterion("modify_by not between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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