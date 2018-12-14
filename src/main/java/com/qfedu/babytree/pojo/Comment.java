package com.qfedu.babytree.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {
    private Integer commId;

    private String commContent;

    private Integer commLikenum;

    @DateTimeFormat
    private Date commTime;

    private Integer storyId;

    private Integer userId;

    private String userNickname;

    private String userImgurl;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserImgurl() {
        return userImgurl;
    }

    public void setUserImgurl(String userImgurl) {
        this.userImgurl = userImgurl;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent == null ? null : commContent.trim();
    }

    public Integer getCommLikenum() {
        return commLikenum;
    }

    public void setCommLikenum(Integer commLikenum) {
        this.commLikenum = commLikenum;
    }

    public Date getCommTime() {
        return commTime;
    }

    public void setCommTime(Date commTime) {
        this.commTime = commTime;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commId=" + commId +
                ", commContent='" + commContent + '\'' +
                ", commLikenum=" + commLikenum +
                ", commTime=" + commTime +
                ", storyId=" + storyId +
                ", userId=" + userId +
                '}';
    }
}