package com.qfedu.babytree.service;

import com.qfedu.babytree.pojo.Sign;
import com.qfedu.babytree.vo.ResultBean;

public interface SignService {
    //根据用户id查找是否有过签到信息
    public Sign selectSignByUserid (Integer sigUserid);

    //根据用户id新插入用户的签到记录
    public ResultBean signUser(Integer sigUserid);
}
