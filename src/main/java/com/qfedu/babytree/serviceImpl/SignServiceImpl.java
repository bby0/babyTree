package com.qfedu.babytree.serviceImpl;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.SignMapper;
import com.qfedu.babytree.pojo.Sign;
import com.qfedu.babytree.service.SignService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TimeZone;


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
            //如果签到过，
            // 取出上次签到的时间（1）
            long sigTime = (long)signMapper.selectByUserid(sigUserid).getSigTime();

            //获取当前时间的00:00的时间戳（2）
            long zero = (System.currentTimeMillis()/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset())/1000;

            //时间1 和 时间2 进行比较
            if (sigTime < zero) {
                //如果上次签到的时间小于当前时间的00:00，则可以进行签到
                // 则在签到次数上进行+1操作，并且更改当前签到的时间
                i = signMapper.updateByUserid(sigUserid);
            } else {
                //如果上次签到的时间大于当前时间的00:00，则今天已经进行过签到，直接返回已签到过
                return ResultUtil.setOK("请勿重复签到", signMapper.selectByUserid(sigUserid));
            }
        } else {

            //如果没有签到过，进行第一次签到的插入操作
            i = signMapper.insertByUserid(sigUserid);
        }

        //再次查询用户的签到信息,并进行返回给前端
        return i > 0 ? ResultUtil.setOK("签到成功", signMapper.selectByUserid(sigUserid)) : ResultUtil.setError(SystemCon.RERROR1, "签到失败", null);
    }

    @Override
    public ResultBean reduceTimesByUserid(Sign sign) {
        //首先获取用户当前的积分
        int times = signMapper.selectByUserid(sign.getSigUserid()).getSigTimes();
        //进行判断
        System.out.println("原来的积分：" + times);
        System.out.println("传入的积分：" + sign.getSigTimes());
        if (times > sign.getSigTimes()) {

            //可以兑换
            return ResultUtil.setOK("兑换成功", signMapper.reduceTimesByUserid(sign));
        } else {
            //积分不足
            return ResultUtil.setError(SystemCon.RERROR1,"积分不足", null);
        }

    }

}
