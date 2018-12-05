package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.UsersLog;

public interface UsersLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersLog record);

    int insertSelective(UsersLog record);

    UsersLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsersLog record);

    int updateByPrimaryKey(UsersLog record);
}