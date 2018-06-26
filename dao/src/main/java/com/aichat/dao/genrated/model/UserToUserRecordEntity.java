package com.aichat.dao.genrated.model;

import java.util.Date;

public class UserToUserRecordEntity {
    private Integer id;

    private Integer userRelationId;

    private String content;

    private Integer sendId;

    private Integer sendType;

    private Integer reciveId;

    private Integer reciveType;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserRelationId() {
        return userRelationId;
    }

    public void setUserRelationId(Integer userRelationId) {
        this.userRelationId = userRelationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getReciveId() {
        return reciveId;
    }

    public void setReciveId(Integer reciveId) {
        this.reciveId = reciveId;
    }

    public Integer getReciveType() {
        return reciveType;
    }

    public void setReciveType(Integer reciveType) {
        this.reciveType = reciveType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}