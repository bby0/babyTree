package com.qfedu.babytree.controller;


import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.service.UserService;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


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

}
