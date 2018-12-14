package com.qfedu.babytree.mapper;

import com.qfedu.babytree.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    //新增用户
    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKeyWithBLOBs(Users record);

    int updateByPrimaryKey(Users record);

    //登录
    Users selectByName(String name);

    int addNotice(@Param("noticeId") Integer noticeId,@Param("userId") Integer userId);

    int checkNotice(@Param("noticeId") Integer noticeId,@Param("userId") Integer userId);
}