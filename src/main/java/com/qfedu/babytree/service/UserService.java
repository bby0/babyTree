package com.qfedu.babytree.service;

import com.qfedu.babytree.pojo.Feedback;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.data.redis.core.StringRedisTemplate;

public interface UserService {
    //新增用户
    ResultBean save(Users user, String ip);

    //校验昵称或手机号是否重复
    ResultBean checkRepeat(String name);

    //根据用户的id查询用户的信息
    ResultBean selectByUserid(Integer userId);

    //修改用户的信息
    ResultBean updataUserInfo(StringRedisTemplate stringRedisTemplate, Users users);

    //提交反馈
    ResultBean insertSelective(Feedback feedback);

    //关注用户
    ResultBean addNotice(Integer noticeId,Integer userId);


}
