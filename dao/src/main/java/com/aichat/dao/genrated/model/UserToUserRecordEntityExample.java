package com.aichat.dao.genrated.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserToUserRecordEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserToUserRecordEntityExample() {
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

        public Criteria andUserRelationIdIsNull() {
            addCriterion("user_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdIsNotNull() {
            addCriterion("user_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdEqualTo(Integer value) {
            addCriterion("user_relation_id =", value, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdNotEqualTo(Integer value) {
            addCriterion("user_relation_id <>", value, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdGreaterThan(Integer value) {
            addCriterion("user_relation_id >", value, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_relation_id >=", value, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdLessThan(Integer value) {
            addCriterion("user_relation_id <", value, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_relation_id <=", value, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdIn(List<Integer> values) {
            addCriterion("user_relation_id in", values, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdNotIn(List<Integer> values) {
            addCriterion("user_relation_id not in", values, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdBetween(Integer value1, Integer value2) {
            addCriterion("user_relation_id between", value1, value2, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andUserRelationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_relation_id not between", value1, value2, "userRelationId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNull() {
            addCriterion("send_id is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("send_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(Integer value) {
            addCriterion("send_id =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(Integer value) {
            addCriterion("send_id <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(Integer value) {
            addCriterion("send_id >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_id >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(Integer value) {
            addCriterion("send_id <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_id <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<Integer> values) {
            addCriterion("send_id in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<Integer> values) {
            addCriterion("send_id not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(Integer value1, Integer value2) {
            addCriterion("send_id between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_id not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("send_type is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("send_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(Integer value) {
            addCriterion("send_type =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(Integer value) {
            addCriterion("send_type <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(Integer value) {
            addCriterion("send_type >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_type >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(Integer value) {
            addCriterion("send_type <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("send_type <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<Integer> values) {
            addCriterion("send_type in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<Integer> values) {
            addCriterion("send_type not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(Integer value1, Integer value2) {
            addCriterion("send_type between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("send_type not between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andReciveIdIsNull() {
            addCriterion("recive_id is null");
            return (Criteria) this;
        }

        public Criteria andReciveIdIsNotNull() {
            addCriterion("recive_id is not null");
            return (Criteria) this;
        }

        public Criteria andReciveIdEqualTo(Integer value) {
            addCriterion("recive_id =", value, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdNotEqualTo(Integer value) {
            addCriterion("recive_id <>", value, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdGreaterThan(Integer value) {
            addCriterion("recive_id >", value, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recive_id >=", value, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdLessThan(Integer value) {
            addCriterion("recive_id <", value, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdLessThanOrEqualTo(Integer value) {
            addCriterion("recive_id <=", value, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdIn(List<Integer> values) {
            addCriterion("recive_id in", values, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdNotIn(List<Integer> values) {
            addCriterion("recive_id not in", values, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdBetween(Integer value1, Integer value2) {
            addCriterion("recive_id between", value1, value2, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recive_id not between", value1, value2, "reciveId");
            return (Criteria) this;
        }

        public Criteria andReciveTypeIsNull() {
            addCriterion("recive_type is null");
            return (Criteria) this;
        }

        public Criteria andReciveTypeIsNotNull() {
            addCriterion("recive_type is not null");
            return (Criteria) this;
        }

        public Criteria andReciveTypeEqualTo(Integer value) {
            addCriterion("recive_type =", value, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeNotEqualTo(Integer value) {
            addCriterion("recive_type <>", value, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeGreaterThan(Integer value) {
            addCriterion("recive_type >", value, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("recive_type >=", value, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeLessThan(Integer value) {
            addCriterion("recive_type <", value, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeLessThanOrEqualTo(Integer value) {
            addCriterion("recive_type <=", value, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeIn(List<Integer> values) {
            addCriterion("recive_type in", values, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeNotIn(List<Integer> values) {
            addCriterion("recive_type not in", values, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeBetween(Integer value1, Integer value2) {
            addCriterion("recive_type between", value1, value2, "reciveType");
            return (Criteria) this;
        }

        public Criteria andReciveTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("recive_type not between", value1, value2, "reciveType");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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