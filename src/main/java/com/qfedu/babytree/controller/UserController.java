package com.qfedu.babytree.controller;


import com.alibaba.fastjson.JSON;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.pojo.*;
import com.qfedu.babytree.service.*;
import com.qfedu.babytree.token.Token;
import com.qfedu.babytree.token.TokenUtil;
import com.qfedu.babytree.util.OSSUtil;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.util.UserUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SignService signService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private BabyService babyService;
    @Autowired
    private OSSUtil ossUtil;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private OSSUtil OssUtil;


    @PostMapping("register")
    public ResultBean save(Users user, HttpServletRequest request) {
        System.out.println(user.getUserNickname());
        return userService.save(user, request.getRemoteAddr());
    }

    @GetMapping("usercheck")
    public ResultBean checkName(String userNickname) {
        return userService.checkRepeat(userNickname);
    }

    //获取用户的信息
    @GetMapping("userInfo")
    public ResultBean selectUserInfo(HttpServletRequest request) {
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


    //修改用户的个人信息
    @PostMapping("updataUserInfo")
    public ResultBean updataUserInfo(Users users) {
        System.out.println("user:" + users);
        return userService.updataUserInfo(stringRedisTemplate, users);
    }

    //积分兑换会员
    @PostMapping("exchangeVip")
    public ResultBean exchangeVip(Sign sign) {
        sign.setSigUserid(UserUtil.getUserId(stringRedisTemplate));
        ResultBean resultBean = signService.reduceTimesByUserid(sign);

        if (resultBean.getCode() == SystemCon.ROK) {
            //兑换成功后将用户设置为会员
            Users users = new Users();
            users.setUserLevel(1);
            return ResultUtil.setOK("兑换成功", userService.updataUserInfo(stringRedisTemplate, users));
        } else {
            return resultBean;
        }
    }

    //收藏文章
    @PostMapping("collectArticle")
    public ResultBean collectArticle(Collection collection) {

        collection.setColUserid(UserUtil.getUserId(stringRedisTemplate));
        return collectionService.CollectArticle(collection);

    }

    //根据用户id查看当前收藏的文章
    @GetMapping("selectArticlesByUserid")
    public ResultBean selectArticlesByUserid() {

        return collectionService.selectArticlesByUserid(UserUtil.getUserId(stringRedisTemplate));

    }

    //添加该用户的宝宝
    @PostMapping("addBaby")
    public ResultBean addBaby(Baby baby, MultipartFile file) throws IOException {
        System.out.println("文件"+file);
        System.out.println("宝贝信息"+baby);

        String path = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3708622691,2971422807&fm=27&gp=0.jpg";
//        if (!file.isEmpty()) {
//            path = ossUtil.fileUp(file.getOriginalFilename(), file.getBytes());
//            System.out.println("文件" + path);
//        }

        baby.setUserId(UserUtil.getUserId(stringRedisTemplate));
        baby.setBabyImgurl(path);
        return babyService.addBaby(baby);

    }

    //根据用户的id查看对应的小宝贝呀~~
    @GetMapping("selectBabyByUserid")
    public ResultBean selectBabyByUserid() {

        return babyService.selectByUserid(UserUtil.getUserId(stringRedisTemplate));
    }

    //根据修改小宝贝的信息呀~~
    @PostMapping("updateBabyByid")
    public ResultBean updateBabyByid(Baby baby, MultipartFile file) throws IOException {
        String path = null;
        if (!file.isEmpty()) {
            path = ossUtil.fileUp(file.getOriginalFilename(), file.getBytes());
            System.out.println("文件" + path);
        }
        baby.setUserId(UserUtil.getUserId(stringRedisTemplate));
        baby.setBabyImgurl(path);

        return babyService.updateBabyByid(baby);
    }
    /**
     * 用户反馈
     */
    @PostMapping("addFeedBack")
    public ResultBean addFeedBack(Feedback feedback,MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String path=OssUtil.fileUp(file.getOriginalFilename(),file.getBytes());
            System.out.println("文件地址:"+path);
            feedback.setFeeImgurl(path);
            userService.insertSelective(feedback);

            return ResultUtil.setOK("提交成功",path);
        }else{
            return ResultUtil.setError(SystemCon.RERROR1,"请选择上传文件",null);
        }

    }

    @GetMapping("selectSignByuserid")
    public ResultBean selectSignByuserid() throws IOException {


        return ResultUtil.setOK("当前用户的签到记录", signService.selectSignByUserid(UserUtil.getUserId(stringRedisTemplate)));
    }

    @GetMapping("doNotice")
    public ResultBean doNotice(Integer noticeId) {
        System.out.println(noticeId);

        Integer userId = UserUtil.getUserId(stringRedisTemplate);

        return userService.addNotice(noticeId,userId);
    }









}
