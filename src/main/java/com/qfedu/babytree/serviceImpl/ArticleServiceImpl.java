package com.qfedu.babytree.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.qfedu.babytree.mapper.ArticleMapper;
import com.qfedu.babytree.pojo.Article;
import com.qfedu.babytree.service.ArticleService;
import com.qfedu.babytree.vo.ResponseVo;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResponseVo<Article> articelList(String pageNum, String pageSize) {
    List<Article> list= articleMapper.selectAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        ResponseVo<Article> vo = new ResponseVo<>();
        if (pageInfo.getList() != null) {
            vo = ResponseVo.OK();
            vo.setData(pageInfo.getList());
            vo.setCount(pageInfo.getTotal());
        } else {
            vo = ResponseVo.ERROR();
        }
        return vo;
    }
}
