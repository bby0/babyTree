package com.qfedu.babytree.pojo;

import java.util.Date;

public class UsersLog {
    private Integer id;

    private Integer uid;

    private String content;

    private Date createtime;

    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    @Override
    public String toString() {
        return "UsersLog{" +
                "id=" + id +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", ip='" + ip + '\'' +
                '}';
    }
}