package com.qfedu.babytree.controller;


import com.alibaba.fastjson.JSON;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.pojo.Story;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.service.StoryService;
import com.qfedu.babytree.token.TokenUtil;
import com.qfedu.babytree.vo.ResponseVo;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @GetMapping("/getStorybyUid")
    public ResponseVo<Story> getStory(Integer pageNum, Integer pageSize) {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        Integer uid = user.getUserId();
        System.out.println("这是用户id:"+uid);

        return storyService.getStory(uid, pageNum, pageSize);
    }

    @PostMapping("/Like")
    public ResultBean giveLike(Integer uid,Integer tid) {

        System.out.println("用户id="+uid+", 故事id=" + tid);
        return storyService.giveLike(uid, tid);

    }




}
