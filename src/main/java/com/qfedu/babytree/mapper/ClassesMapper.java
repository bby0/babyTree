package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Classes;
import com.qfedu.babytree.pojo.Classtype;

import java.util.List;
import java.util.Map;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer clasId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer clasId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKeyWithBLOBs(Classes record);

    int updateByPrimaryKey(Classes record);

    //查询所有课程信息
    List<Map<Object,String>> selectAll(Classtype classtype);
}