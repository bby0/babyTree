package com.qfedu.babytree.pojo;

public class Comment {
    private Integer commId;

    private String commContent;

    private Integer commLikenum;

    private Integer storyId;

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

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }
}