package com.qfedu.babytree.service;

import com.qfedu.babytree.pojo.Article;
import com.qfedu.babytree.vo.ResponseVo;
public interface ArticleService {
    //查询所有文章
    public ResponseVo<Article> articelList(String pageNum, String pageSize);
}
