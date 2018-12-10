package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Classtype;

import java.util.List;

public interface ClasstypeMapper {
    int deleteByPrimaryKey(Integer clsTypeId);

    int insert(Classtype record);

    int insertSelective(Classtype record);

    Classtype selectByPrimaryKey(Integer clsTypeId);

    int updateByPrimaryKeySelective(Classtype record);

    int updateByPrimaryKey(Classtype record);

    //查询所有的课程类型
    List<Classtype> selectTypeAll();
}