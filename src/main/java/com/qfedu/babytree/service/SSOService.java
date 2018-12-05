package com.qfedu.babytree.service;

import com.qfedu.babytree.vo.ResultBean;

public interface SSOService {
    //登录
    ResultBean login(String name, String password, String ip);
    //检验是否登录
    ResultBean checkLogin(String token);
    //注销
    ResultBean loginout(String token);
}
