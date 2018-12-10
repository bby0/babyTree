package com.qfedu.babytree.controller;

import com.qfedu.babytree.service.ClassService;
import com.qfedu.babytree.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassesController {
    @Autowired
    private ClassService classService;

    @GetMapping("classes")
    public ResponseVo classesList(String pageNum, String pageSize,@RequestParam("clasId") Integer clasId){
        System.out.println("clasId的值： "+clasId);
       return classService.classesList(pageNum,pageSize,clasId);
    }
}
