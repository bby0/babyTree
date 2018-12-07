package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Story;

import java.util.List;

public interface StoryMapper {
    int deleteByPrimaryKey(Integer stoId);

    int insert(Story record);

    int insertSelective(Story record);

    Story selectByPrimaryKey(Integer stoId);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKeyWithBLOBs(Story record);

    int updateByPrimaryKey(Story record);
    //查询所有故事
    List<Story> selectStory(Integer id);

}