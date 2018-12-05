package com.qfedu.babytree.service;

import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.vo.ResultBean;

public interface UserService {
    //新增用户
    ResultBean save(Users user, String ip);

    //校验昵称或手机号是否重复
    ResultBean checkRepeat(String name);

}
