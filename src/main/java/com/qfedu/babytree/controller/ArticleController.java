package com.qfedu.babytree.controller;

import com.qfedu.babytree.pojo.Article;
import com.qfedu.babytree.service.ArticleService;
import com.qfedu.babytree.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("article")
    public ResponseVo<Article> articleList(String pageNum, String pageSize) {
        return articleService.articelList(pageNum,pageSize);
    }
}
