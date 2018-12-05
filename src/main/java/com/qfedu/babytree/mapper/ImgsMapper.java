package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Imgs;

public interface ImgsMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(Imgs record);

    int insertSelective(Imgs record);

    Imgs selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(Imgs record);

    int updateByPrimaryKey(Imgs record);
}