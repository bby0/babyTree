package com.qfedu.babytree.service;

import com.qfedu.babytree.pojo.Collection;
import com.qfedu.babytree.vo.ResultBean;

public interface CollectionService {
    //用户收藏文章
    public ResultBean CollectArticle (Collection collection);

    //查看当前用户所收藏的文章
    public ResultBean selectArticlesByUserid (Integer userid);
}
