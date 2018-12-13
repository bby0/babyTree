package com.qfedu.babytree.serviceImpl;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.CollectionMapper;
import com.qfedu.babytree.pojo.Collection;
import com.qfedu.babytree.service.CollectionService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResultBean CollectArticle(Collection collection) {

        int i = collectionMapper.insertSelective(collection);

        return i > 0 ? ResultUtil.setOK("收藏成功", null) : ResultUtil.setError(SystemCon.RERROR1, "收藏失败", null);
    }

    @Override
    public ResultBean selectArticlesByUserid(Integer userid) {
        return ResultUtil.setOK("当前用户收藏的文章", collectionMapper.selectByUserid(userid));
    }
}
