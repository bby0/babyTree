package com.qfedu.babytree.pojo;

public class Classtype {
    private Integer clsTypeId;

    private String clsTypeName;

    public Integer getClsTypeId() {
        return clsTypeId;
    }

    public void setClsTypeId(Integer clsTypeId) {
        this.clsTypeId = clsTypeId;
    }

    public String getClsTypeName() {
        return clsTypeName;
    }

    public void setClsTypeName(String clsTypeName) {
        this.clsTypeName = clsTypeName == null ? null : clsTypeName.trim();
    }
}