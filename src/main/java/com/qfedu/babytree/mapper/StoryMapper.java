package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Story;

import java.util.List;
import java.util.Map;

public interface StoryMapper {
    int deleteByPrimaryKey(Integer stoId);

    int insert(Story record);

    int insertSelective(Story record);

    Story selectByPrimaryKey(Integer stoId);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKeyWithBLOBs(Story record);

    int updateByPrimaryKey(Story record);
    //查询所有故事
    List<Story> selectStory(Integer uid);
    //点赞
    int giveLike(Integer uid, Integer tid);
    //我的社区空间头部
    List<Map<String,Object>> getMySpaceinfo(Integer uid);
    //查询我的故事
    List<Story> getmyStory(Integer uid);


}