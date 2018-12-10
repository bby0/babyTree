package com.qfedu.babytree.pojo;

public class Story {
    private Integer stoId;

    private Integer stoUserId;

    private Integer stoBabyId;

    private Integer stoLikenum;

    private String stoContent;

    private Users users;

    private Imgs imgs;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Imgs getImgs() {
        return imgs;
    }

    public void setImgs(Imgs imgs) {
        this.imgs = imgs;
    }

    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
    }

    public Integer getStoUserId() {
        return stoUserId;
    }

    public void setStoUserId(Integer stoUserId) {
        this.stoUserId = stoUserId;
    }

    public Integer getStoBabyId() {
        return stoBabyId;
    }

    public void setStoBabyId(Integer stoBabyId) {
        this.stoBabyId = stoBabyId;
    }

    public Integer getStoLikenum() {
        return stoLikenum;
    }

    public void setStoLikenum(Integer stoLikenum) {
        this.stoLikenum = stoLikenum;
    }

    public String getStoContent() {
        return stoContent;
    }

    public void setStoContent(String stoContent) {
        this.stoContent = stoContent == null ? null : stoContent.trim();
    }
}