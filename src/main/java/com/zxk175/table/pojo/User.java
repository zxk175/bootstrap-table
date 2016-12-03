package com.zxk175.table.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {
    private Long id;

    @JsonProperty("name")
    private String userName;

    @JsonProperty("phone")
    private String userPhone;

    @JsonProperty("email")
    private String userEmail;

    @JsonProperty("pwd")
    private String userPwd;

    @JsonProperty("sex")
    private Short userSex;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty("ctime")
    protected Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty("mtime")
    private Date modifyTime;

    @JsonProperty("delete")
    private Short isDelete;

    public User(Long id, String userName, String userPhone, String userEmail, String userPwd, Short userSex, Date createTime, Date modifyTime, Short isDelete) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.isDelete = isDelete;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Short getUserSex() {
        return userSex;
    }

    public void setUserSex(Short userSex) {
        this.userSex = userSex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }
}