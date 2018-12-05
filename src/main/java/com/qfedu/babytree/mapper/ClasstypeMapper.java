package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Classtype;

public interface ClasstypeMapper {
    int deleteByPrimaryKey(Integer clsTypeId);

    int insert(Classtype record);

    int insertSelective(Classtype record);

    Classtype selectByPrimaryKey(Integer clsTypeId);

    int updateByPrimaryKeySelective(Classtype record);

    int updateByPrimaryKey(Classtype record);
}