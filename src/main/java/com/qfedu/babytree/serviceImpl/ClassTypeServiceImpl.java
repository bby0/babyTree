package com.qfedu.babytree.serviceImpl;
import com.qfedu.babytree.mapper.ClasstypeMapper;
import com.qfedu.babytree.pojo.Classtype;
import com.qfedu.babytree.service.ClassTypeService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {

    @Autowired
private ClasstypeMapper classtypeMapper;
    @Override
    public ResultBean classTypeList() {
        List<Classtype> list= classtypeMapper.selectTypeAll();
        return  list== null? ResultUtil.setError(2000,"查询失败",null):ResultUtil.setOK("查询成功",list);
    }
}
