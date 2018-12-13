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
}
