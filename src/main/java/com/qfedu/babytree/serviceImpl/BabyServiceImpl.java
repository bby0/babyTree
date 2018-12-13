package com.qfedu.babytree.serviceImpl;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.BabyMapper;
import com.qfedu.babytree.pojo.Baby;
import com.qfedu.babytree.service.BabyService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BabyServiceImpl implements BabyService {
    @Autowired
    private BabyMapper babyMapper;

    @Override
    public ResultBean addBaby(Baby baby) {

        int i = babyMapper.insertSelective(baby);

        return i > 0 ? ResultUtil.setOK("添加成功", babyMapper.insertSelective(baby)) : ResultUtil.setError(SystemCon.RERROR1, "添加失败", null);
    }

    @Override
    public ResultBean selectByUserid(Integer userId) {

        return ResultUtil.setOK("查询成功", babyMapper.selectByUserid(userId));
    }

    @Override
    public ResultBean updateBabyByid(Baby baby) {

        int i = babyMapper.updateByPrimaryKeySelective(baby);
        return i > 0 ? ResultUtil.setOK("修改成功", babyMapper.selectByPrimaryKey(baby.getBabyId())) : ResultUtil.setError(SystemCon.RERROR1, "修改失败", null);
    }
}
