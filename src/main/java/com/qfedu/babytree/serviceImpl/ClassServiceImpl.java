package com.qfedu.babytree.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.qfedu.babytree.mapper.ClassesMapper;
import com.qfedu.babytree.service.ClassService;
import com.qfedu.babytree.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassesMapper classesMapper;


    @Override
    public ResponseVo classesList(String pageNum, String pageSize,int clasId) {
        System.out.println("clasId的值： "+clasId);
        List<Map<Object,String>> list= classesMapper.selectAll(clasId);
        PageInfo<Map<Object,String>> pageInfo = new PageInfo<>(list);
        ResponseVo vo = new ResponseVo();
        if (pageInfo.getList() != null) {
            vo = ResponseVo.OK();
            vo.setData(pageInfo.getList());
          vo.setCount(pageInfo.getTotal());
        } else {
            vo.ERROR();
        }
        return vo;
    }
}
