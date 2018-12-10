package com.qfedu.babytree.controller;

import com.qfedu.babytree.service.ClassTypeService;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassTypeController {
    @Autowired
    private ClassTypeService classTypeService;

    @GetMapping("classType")
    public ResultBean classTypeList(){
    return classTypeService.classTypeList();
    }
}
