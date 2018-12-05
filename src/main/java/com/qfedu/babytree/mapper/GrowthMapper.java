package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Growth;

public interface GrowthMapper {
    int deleteByPrimaryKey(Integer growthId);

    int insert(Growth record);

    int insertSelective(Growth record);

    Growth selectByPrimaryKey(Integer growthId);

    int updateByPrimaryKeySelective(Growth record);

    int updateByPrimaryKey(Growth record);
}