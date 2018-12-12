package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    //添加评论
    int doComment(Comment comment);

}