package com.qfedu.babytree.controller;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.service.SSOService;
import com.qfedu.babytree.token.TokenUtil;
import com.qfedu.babytree.util.CookieUtil;
import com.qfedu.babytree.util.StringUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2018/11/29 14:51
 */
@RestController
public class SSOController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SSOService ssoService;

    //登录
    @PostMapping("userlogin")
    public ResultBean login(String userNickname, String userPassword, HttpServletRequest request, HttpServletResponse response){
        String token= CookieUtil.getCk(request,SystemCon.TOKECOOKIE);

        if(StringUtil.checkEmpty(token)){
            ResultBean rb=ssoService.login(userNickname,userPassword,request.getRemoteAddr());
            System.out.println("开始：");
            if(rb.getCode()== SystemCon.ROK){
                //存储令牌到Cookie
               CookieUtil.setCK(response,SystemCon.TOKECOOKIE,rb.getMsg());
               rb.setMsg("登录成功");
               return rb;
            }else {
                return rb;
            }
        }else{
            //存在Token
            //校验Token
            System.out.println("登陆中验证 ：");
            return ssoService.checkLogin(token);
        }
    }
    //检查是否登录
    @GetMapping("userlogincheck")
    public ResultBean check(HttpServletRequest request, HttpServletResponse response){
        String tk=CookieUtil.getCk(request,SystemCon.TOKECOOKIE);
        ResultBean resultBean=ssoService.checkLogin(tk);
        System.out.println(1);
        if(resultBean.getCode()==SystemCon.ROK){
            //存在就刷新时间
            //存在就刷新时间
            CookieUtil.setCK(response,SystemCon.TOKECOOKIE,TokenUtil.updateToken(TokenUtil.parseToken(tk)));
            //Token无效 Cookie就需要删除

        }else{
            Cookie cookie=new Cookie(SystemCon.TOKECOOKIE,"");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return resultBean;
    }
    //注销
    @GetMapping("userloginout")
    public ResultBean loginOut(HttpServletRequest request, HttpServletResponse response){
        ResultBean resultBean=ssoService.loginout(CookieUtil.getCk(request,SystemCon.TOKECOOKIE));
        //Token无效 Cookie就需要删除
        Cookie cookie=new Cookie(SystemCon.TOKECOOKIE,"");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return resultBean;
    }
}
