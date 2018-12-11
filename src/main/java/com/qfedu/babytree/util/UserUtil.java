package com.qfedu.babytree.util;

import com.alibaba.fastjson.JSON;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class UserUtil {

    //public static StringRedisTemplate stringRedisTemplate;

    //获取用户的信息
    public static Users getUser(StringRedisTemplate stringRedisTemplate) {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        return user;
    }

    //获取用户的id
    public static int getUserId(StringRedisTemplate stringRedisTemplate) {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        return user.getUserId();
    }

}
