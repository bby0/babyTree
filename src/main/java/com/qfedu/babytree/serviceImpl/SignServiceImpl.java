package com.qfedu.babytree.serviceImpl;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.SignMapper;
import com.qfedu.babytree.pojo.Sign;
import com.qfedu.babytree.service.SignService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    @Override
    public Sign selectSignByUserid(Integer sigUserid) {
        return signMapper.selectByUserid(sigUserid);
    }

    @Override
    public ResultBean signUser(Integer sigUserid) {
        //首先判断该用户是否为第一次签到

        Sign sign = signMapper.selectByUserid(sigUserid);
        //判断是否有过签到
        int i;
        if (sign != null || sign.equals("")) {
            //如果签到过，则在签到次数上进行+1操作，并且更改当前签到的时间
            i = signMapper.updateByUserid(sigUserid);

        } else {
            //如果没有签到过，进行第一次签到的插入操作
            i = signMapper.insertByUserid(sigUserid);

        }

        //再次查询用户的签到信息
        Sign sign1 = signMapper.selectByUserid(sigUserid);
        return i > 0 ? ResultUtil.setOK("签到成功", sign1) : ResultUtil.setError(SystemCon.RERROR1, "签到失败", null);
    }

}
