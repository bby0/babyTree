package com.qfedu.babytree.service;

import com.qfedu.babytree.pojo.Baby;
import com.qfedu.babytree.vo.ResultBean;

public interface BabyService {
    //添加宝宝
    public ResultBean addBaby(Baby baby);

    //查询宝宝
    public ResultBean selectByUserid(Integer userId);

    //修改宝宝信息
    public ResultBean updateBabyByid(Baby baby);
}
