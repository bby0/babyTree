package com.qfedu.babytree.service;

import com.qfedu.babytree.pojo.Comment;
import com.qfedu.babytree.pojo.Story;
import com.qfedu.babytree.vo.ResponseVo;
import com.qfedu.babytree.vo.ResultBean;

public interface StoryService {

    ResponseVo<Story> getStory(Integer uid, Integer pageNum, Integer pageSize);

    ResultBean giveLike(Integer uid,Integer tid);

    ResultBean getMySpaceInfo(Integer uid);

    ResultBean getMyStory(Integer uid);

    ResultBean doComment(Comment comment);

    ResultBean getStoryDetail(Integer stoUserId,Integer stoId);


}
