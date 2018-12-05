package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Story;

public interface StoryMapper {
    int deleteByPrimaryKey(Integer stoId);

    int insert(Story record);

    int insertSelective(Story record);

    Story selectByPrimaryKey(Integer stoId);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKeyWithBLOBs(Story record);

    int updateByPrimaryKey(Story record);
}