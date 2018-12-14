package com.qfedu.babytree.controller;


import com.alibaba.fastjson.JSON;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.pojo.*;
import com.qfedu.babytree.service.StoryService;
import com.qfedu.babytree.token.TokenUtil;
import com.qfedu.babytree.util.OSSUtil;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResponseVo;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    /**
     * 社区故事（用户所关注的人）
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getStorybyUid")
    public ResponseVo<Story> getStory(Integer pageNum, Integer pageSize) {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        Integer uid = user.getUserId();
        System.out.println("这是用户id:" + uid);

        return storyService.getStory(uid, pageNum, pageSize);
    }

    /**
     * 点赞
     *
     * @param uid
     * @param tid
     * @return
     */

    @PostMapping("/Like")
    public ResultBean giveLike(Integer uid, Integer tid) {

        System.out.println("用户id=" + uid + ", 故事id=" + tid);
        return storyService.giveLike(uid, tid);

    }

    /**
     * 我的社区故事的头部信息
     *
     * @return
     */
    @GetMapping("/mySpaceInfo")
    public ResultBean getMySpaceInfo() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        Integer uid = user.getUserId();

        return storyService.getMySpaceInfo(uid);

    }

    /**
     * 我的社区故事
     *
     * @return
     */
    @GetMapping("/myStory")
    public ResultBean getMyStory() {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        Integer uid = user.getUserId();

        return storyService.getMyStory(uid);
    }

    /**
     * 评论，需要参数是用户填写的评论内容，评论的故事id
     *
     * @param comment
     * @return
     */
    @PostMapping("/doComment")
    public ResultBean doComment(Comment comment) {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        Integer uid = user.getUserId();

        comment.setUserId(uid);

        return storyService.doComment(comment);

    }

    /**
     * 说说的详情
     */

    @GetMapping("/getStoryDetail")
    public ResultBean getStoryDetail(Integer stoUserId, Integer stoId) {
        System.out.println(stoUserId);
        System.out.println(stoId);

        return storyService.getStoryDetail(stoUserId, stoId);

    }

    /**
     * 获取评论列表
     */
    @GetMapping("/getCommentList")
    public ResultBean getCommentList(Integer stoId) {

        return storyService.getComment(stoId);
    }

    @PostMapping("/addStory")
    public ResultBean addStory(Story story, MultipartFile[] file) throws IOException {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(ops.get(SystemCon.TOKENHASH)).getContent(), Users.class);
        Integer uid = user.getUserId();

        System.out.println("故事图片"+file);
        System.out.println("故事内容"+story);

        story.setStoUserId(uid);


        if (story != null) {

            storyService.addStory(story,file);
            return ResultUtil.setOK("存储成功", null);
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "请输入内容", null);
        }


    }
}




