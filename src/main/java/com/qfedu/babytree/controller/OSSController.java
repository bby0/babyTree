package com.qfedu.babytree.controller;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.util.OSSUtil;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2018/12/2 10:10
 */
@RestController
public class OSSController {

    @Autowired
    private OSSUtil ossUtil;
    //文件上传
    @PostMapping("ossupload")
    public ResultBean upload(Users users, MultipartFile file) throws IOException {
        System.out.println("用户"+users);
        System.out.println("文件"+file);

        if(!file.isEmpty()){
            String path=ossUtil.fileUp(file.getOriginalFilename(),file.getBytes());
            System.out.println("文件地址:"+path);
            return ResultUtil.setOK("存储成功",path);
        }else{
            return ResultUtil.setError(SystemCon.RERROR1,"请选择上传文件",null);
        }
    }
}