package com.qfedu.babytree.service;
import com.qfedu.babytree.vo.ResponseVo;

public interface ClassService {
    //查询课程信息
    public ResponseVo classesList(String pageNum, String pageSize,int clasId);
}
