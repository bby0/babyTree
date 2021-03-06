package com.qfedu.babytree.controller;


import com.alibaba.fastjson.JSON;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.pojo.*;
import com.qfedu.babytree.redis.RedisUtil;
import com.qfedu.babytree.service.StoryService;
import com.qfedu.babytree.token.TokenUtil;
import com.qfedu.babytree.util.CookieUtil;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResponseVo;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisUtil redisUtil;





    /**
     * 社区故事（用户所关注的人）
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getStorybyUid")
    public ResponseVo<Story> getStory(Integer pageNum, Integer pageSize, HttpServletRequest request) {
        //System.out.println("Ck"+redisUtil.get(CookieUtil.getCk(request,SystemCon.TOKECOOKIE),0));
        //ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        Users user = JSON.parseObject(TokenUtil.parseToken(CookieUtil.getCk(request,SystemCon.TOKECOOKIE)).getContent(), Users.class);
        System.out.println(user);
        Integer uid = user.getUserId();
        System.out.println("这是用户id:" + uid);

        return storyService.getStory(uid, pageNum, pageSize);
    }

    @GetMapping("/getAllStory")
    public ResponseVo<Story> getAllStory(Integer pageNum, Integer pageSize) {

        return storyService.getAllStory( pageNum, pageSize);

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

//        Integer Uid = Integer.valueOf(uid);
//        Integer Tid = Integer.valueOf(tid);

        System.out.println("用户id=" + uid + ", 故事id=" + tid);
        return storyService.giveLike(uid, tid);

    }

    /**
     * 我的社区故事的头部信息
     *
     * @return
     */
    @GetMapping("/mySpaceInfo")
    public ResultBean getMySpaceInfo(HttpServletRequest request) {
        Users user = JSON.parseObject(TokenUtil.parseToken(CookieUtil.getCk(request,SystemCon.TOKECOOKIE)).getContent(), Users.class);

        Integer uid = user.getUserId();

        return storyService.getMySpaceInfo(uid);

    }

    /**
     * 我的社区故事
     *
     * @return
     */
    @GetMapping("/myStory")
    public ResultBean getMyStory(HttpServletRequest request) {
        Users user = JSON.parseObject(TokenUtil.parseToken(CookieUtil.getCk(request,SystemCon.TOKECOOKIE)).getContent(), Users.class);

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
    public ResultBean doComment(Comment comment,HttpServletRequest request) {
        Users user = JSON.parseObject(TokenUtil.parseToken(CookieUtil.getCk(request,SystemCon.TOKECOOKIE)).getContent(), Users.class);

        Integer uid = user.getUserId();

        System.out.println(comment);

        comment.setUserId(uid);

        return storyService.doComment(comment);

    }

    /**
     * 说说的详情
     */

    @GetMapping("/getStoryDetail")
    public ResultBean getStoryDetail( Integer stoId) {
        System.out.println("故事详情的id="+stoId);

        return storyService.getStoryDetail( stoId);

    }

    /**
     * 获取评论列表
     */
    @GetMapping("/getCommentList")
    public ResultBean getCommentList(Integer stoId) {

        return storyService.getComment(stoId);
    }

    @PostMapping("/addStory")
    public ResultBean addStory(Story story, MultipartFile[] file,HttpServletRequest request) throws IOException {
        Users user = JSON.parseObject(TokenUtil.parseToken(CookieUtil.getCk(request,SystemCon.TOKECOOKIE)).getContent(), Users.class);

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




