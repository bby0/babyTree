package com.qfedu.babytree.pojo;

public class Classes {
    private Integer clasId;

    private String clasName;

    private String clasTeacher;

    private String clasTeatel;

    private Integer clasTypeid;

    private Integer clasState;

    public Integer getClasId() {
        return clasId;
    }

    public void setClasId(Integer clasId) {
        this.clasId = clasId;
    }

    public String getClasName() {
        return clasName;
    }

    public void setClasName(String clasName) {
        this.clasName = clasName == null ? null : clasName.trim();
    }

    public String getClasTeacher() {
        return clasTeacher;
    }

    public void setClasTeacher(String clasTeacher) {
        this.clasTeacher = clasTeacher == null ? null : clasTeacher.trim();
    }

    public String getClasTeatel() {
        return clasTeatel;
    }

    public void setClasTeatel(String clasTeatel) {
        this.clasTeatel = clasTeatel == null ? null : clasTeatel.trim();
    }

    public Integer getClasTypeid() {
        return clasTypeid;
    }

    public void setClasTypeid(Integer clasTypeid) {
        this.clasTypeid = clasTypeid;
    }

    public Integer getClasState() {
        return clasState;
    }

    public void setClasState(Integer clasState) {
        this.clasState = clasState;
    }
}