package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer clasId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer clasId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}