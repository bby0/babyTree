package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    //添加评论
    int doComment(Comment comment);

    //根据故事id查询所有的故事
    List<Comment> selectCommentByStoId(Integer storyId);

}