package com.qfedu.babytree.pojo;

public class Baby {
    private Integer babyId;

    private Integer userId;

    private Integer babySex;

    private String babyName;

    private Double babyWeight;

    private Double babyHeight;

    private String babyBirth;

    private Integer babyStatus;

    private String babyImgurl;

    public Integer getBabyId() {
        return babyId;
    }

    public void setBabyId(Integer babyId) {
        this.babyId = babyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBabySex() {
        return babySex;
    }

    public void setBabySex(Integer babySex) {
        this.babySex = babySex;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName == null ? null : babyName.trim();
    }

    public Double getBabyWeight() {
        return babyWeight;
    }

    public void setBabyWeight(Double babyWeight) {
        this.babyWeight = babyWeight;
    }

    public Double getBabyHeight() {
        return babyHeight;
    }

    public void setBabyHeight(Double babyHeight) {
        this.babyHeight = babyHeight;
    }

    public String getBabyBirth() {
        return babyBirth;
    }

    public void setBabyBirth(String babyBirth) {
        this.babyBirth = babyBirth == null ? null : babyBirth.trim();
    }

    public Integer getBabyStatus() {
        return babyStatus;
    }

    public void setBabyStatus(Integer babyStatus) {
        this.babyStatus = babyStatus;
    }

    public String getBabyImgurl() {
        return babyImgurl;
    }

    public void setBabyImgurl(String babyImgurl) {
        this.babyImgurl = babyImgurl == null ? null : babyImgurl.trim();
    }

    @Override
    public String toString() {
        return "Baby{" +
                "babyId=" + babyId +
                ", userId=" + userId +
                ", babySex=" + babySex +
                ", babyName='" + babyName + '\'' +
                ", babyWeight=" + babyWeight +
                ", babyHeight=" + babyHeight +
                ", babyBirth='" + babyBirth + '\'' +
                ", babyStatus=" + babyStatus +
                ", babyImgurl='" + babyImgurl + '\'' +
                '}';
    }
}