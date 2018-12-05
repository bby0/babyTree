package com.qfedu.babytree.pojo;

import java.util.Date;

public class Growth {
    private Integer growthId;

    private String growthLength;

    private String growthWigth;

    private Date growthTime;

    private String record;

    private Integer babyId;

    public Integer getGrowthId() {
        return growthId;
    }

    public void setGrowthId(Integer growthId) {
        this.growthId = growthId;
    }

    public String getGrowthLength() {
        return growthLength;
    }

    public void setGrowthLength(String growthLength) {
        this.growthLength = growthLength == null ? null : growthLength.trim();
    }

    public String getGrowthWigth() {
        return growthWigth;
    }

    public void setGrowthWigth(String growthWigth) {
        this.growthWigth = growthWigth == null ? null : growthWigth.trim();
    }

    public Date getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(Date growthTime) {
        this.growthTime = growthTime;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    public Integer getBabyId() {
        return babyId;
    }

    public void setBabyId(Integer babyId) {
        this.babyId = babyId;
    }
}