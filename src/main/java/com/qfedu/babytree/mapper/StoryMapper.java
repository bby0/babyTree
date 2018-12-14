package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Story;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StoryMapper {
    int deleteByPrimaryKey(Integer stoId);
    //添加社区故事
    int insert(Story record);


    int insertSelective(Story record);

    Story selectByPrimaryKey(Integer stoId);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKeyWithBLOBs(Story record);

    int updateByPrimaryKey(Story record);
    //查询所有故事
    List<Story> selectStory(Integer uid);
    //点赞
    int giveLike(@Param("uid")Integer uid,@Param("tid") Integer tid);
    //我的社区空间头部
    List<Map<String,Object>> getMySpaceinfo(Integer uid);
    //查询我的故事
    List<Story> getmyStory(Integer uid);
    //查询故事详情
    List<Story> getStoryDetail(Integer stoId);


}