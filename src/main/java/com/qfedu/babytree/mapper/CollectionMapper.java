package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Collection;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer colId);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer colId);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}