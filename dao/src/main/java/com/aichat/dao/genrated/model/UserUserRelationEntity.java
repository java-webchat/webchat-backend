package com.aichat.dao.genrated.model;

import java.util.Date;

public class UserUserRelationEntity {
    private Integer id;

    private Integer userIdPrimary;

    private Integer userIdSecondary;

    private Date createDate;

    private Date updateDate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIdPrimary() {
        return userIdPrimary;
    }

    public void setUserIdPrimary(Integer userIdPrimary) {
        this.userIdPrimary = userIdPrimary;
    }

    public Integer getUserIdSecondary() {
        return userIdSecondary;
    }

    public void setUserIdSecondary(Integer userIdSecondary) {
        this.userIdSecondary = userIdSecondary;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}