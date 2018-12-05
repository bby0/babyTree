package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer feeId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer feeId);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKeyWithBLOBs(Feedback record);

    int updateByPrimaryKey(Feedback record);
}