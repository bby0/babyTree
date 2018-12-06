package com.qfedu.babytree.controller;


import com.alibaba.fastjson.JSON;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.pojo.Sign;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.service.SignService;
import com.qfedu.babytree.service.UserService;
import com.qfedu.babytree.token.Token;
import com.qfedu.babytree.token.TokenUtil;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SignService signService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @PostMapping("register")
    public ResultBean save(Users user, HttpServletRequest request)

    {
        System.out.println(user.getUserNickname());
        return userService.save(user,request.getRemoteAddr());
    }

    @GetMapping("usercheck")
    public ResultBean checkName(String name){
        return userService.checkRepeat(name);
    }

    //获取用户的信息
    @GetMapping("userInfo")
    public ResultBean selectUserInfo (HttpServletRequest request) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //从token中获取用户id信息进行返回
        Token token = TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH));
        //获取用户对象
        String content1 = token.getContent();
        Users users = JSON.parseObject(content1, Users.class);
        /*另一种转为Java对象
        JSONObject jsonObject = new JSONObject().fromObject(content1);
        Users users = (Users) JSONObject.toBean(jsonObject, Users.class);*/
        return userService.selectByUserid(users.getUserId());
    }

    @PostMapping("userSign")
    public ResultBean userSign() {
        //获取用户信息
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        Integer userId = user.getUserId();

        return signService.signUser(userId);
    }

}
