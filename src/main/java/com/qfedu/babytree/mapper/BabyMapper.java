package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Baby;

import java.util.List;

public interface BabyMapper {
    int deleteByPrimaryKey(Integer babyId);

    int insert(Baby record);

    int insertSelective(Baby record);

    Baby selectByPrimaryKey(Integer babyId);

    int updateByPrimaryKeySelective(Baby record);

    int updateByPrimaryKeyWithBLOBs(Baby record);

    int updateByPrimaryKey(Baby record);

    List<Baby> selectByUserid(Integer userId);
}