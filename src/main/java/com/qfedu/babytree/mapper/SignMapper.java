package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Sign;


public interface SignMapper {
    int deleteByPrimaryKey(Integer sigId);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(Integer sigId);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);

    Sign selectByUserid(Integer sigUserid);

    int insertByUserid(Integer sigUserid);

    int updateByUserid(Integer sigUserid);

    int reduceTimesByUserid(Sign sign);
}