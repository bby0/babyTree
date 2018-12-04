package com.qfedu.babytree.vo;

import java.io.Serializable;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/28 09:20
 */
public class PageBean implements Serializable {
    private int code;
    private String msg;
    private int totalpage;//总页数
    private int totalcount;//总条数
    private int currpage;//当前页码
    private int limit;//每页显示的数量
    private List<Object> data;//数据源

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
