package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}