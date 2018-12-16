package com.qfedu.babytree.pojo;

public class Users {
    private Integer userId;

    private Integer userNoticeid;

    private String userTel;

    private String userNickname;

    private String userPassword;

    private Integer userSex;

    private String userBirth;

    private String userAddress;

    private Integer userLevel;

    private Integer userState;

    private String userDuedate;

    private String userImgurl;

    private Integer noticeNum;

    private Integer fansNum;


    public Integer getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(Integer noticeNum) {
        this.noticeNum = noticeNum;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserNoticeid() {
        return userNoticeid;
    }

    public void setUserNoticeid(Integer userNoticeid) {
        this.userNoticeid = userNoticeid;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth == null ? null : userBirth.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserDuedate() {
        return userDuedate;
    }

    public void setUserDuedate(String userDuedate) {
        this.userDuedate = userDuedate == null ? null : userDuedate.trim();
    }

    public String getUserImgurl() {
        return userImgurl;
    }

    public void setUserImgurl(String userImgurl) {
        this.userImgurl = userImgurl == null ? null : userImgurl.trim();
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userNoticeid=" + userNoticeid +
                ", userTel='" + userTel + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userBirth='" + userBirth + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userLevel=" + userLevel +
                ", userState=" + userState +
                ", userDuedate='" + userDuedate + '\'' +
                ", userImgurl='" + userImgurl + '\'' +
                '}';
    }
}