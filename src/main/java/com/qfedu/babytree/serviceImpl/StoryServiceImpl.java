package com.qfedu.babytree.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.CommentMapper;
import com.qfedu.babytree.mapper.StoryMapper;
import com.qfedu.babytree.pojo.Comment;
import com.qfedu.babytree.pojo.Story;
import com.qfedu.babytree.service.StoryService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResponseVo;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryMapper storyMapper;

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public ResponseVo<Story> getStory(Integer uid, Integer pageNum, Integer pageSize) {

        Integer pageNum1 = 1;
        Integer pageSize1 = 5;

        if (pageNum==null||pageSize==null) {

            pageNum = pageNum1;
            pageSize = pageSize1;

        }


        PageHelper.startPage(pageNum, pageSize);
        List<Story> list = storyMapper.selectStory(uid);
        PageInfo<Story> page = new PageInfo<Story>(list);
        ResponseVo<Story> vo = ResponseVo.OK();

        List<Story> count = storyMapper.selectStory(uid);
        System.out.println(count.size());

        vo.setData(page.getList());
        vo.setCount(count.size());

        return vo;
    }

    @Override
    public ResultBean giveLike(Integer uid, Integer tid) {
        if(storyMapper.giveLike(uid, tid)<=0){
            return ResultUtil.setOK("点赞失败",null);
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"点赞成功",null);
        }

    }

    @Override
    public ResultBean getMySpaceInfo(Integer uid) {



        if(storyMapper.getMySpaceinfo(uid)!=null){
            return ResultUtil.setOK("获取成功",storyMapper.getMySpaceinfo(uid));
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"获取失败",null);
        }
    }

    @Override
    public ResultBean getMyStory(Integer uid) {
        if(storyMapper.getmyStory(uid)!=null){
            return ResultUtil.setOK("获取成功",storyMapper.getmyStory(uid));
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"获取失败",null);
        }
    }

    @Override
    public ResultBean doComment(Comment comment) {
        if(commentMapper.doComment(comment)>0){
            return ResultUtil.setOK("评论成功",null);
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"评论失败",null);
        }
    }

    @Override
    public ResultBean getStoryDetail(Integer stoUserId, Integer stoId) {

//        Integer stoUserid = Integer.valueOf(stoUserId);
//        Integer stoid = Integer.valueOf(stoUserId);

        //List<Story> data = storyMapper.getStoryDetail(stoUserId,stoId);
        System.out.println(storyMapper.getStoryDetail(stoUserId,stoId));

        if(storyMapper.getStoryDetail(stoUserId,stoId)!=null){
            return ResultUtil.setOK("获取成功",storyMapper.getStoryDetail(stoUserId,stoId));
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"获取失败",null);
        }
    }

    @Override
    public ResultBean getComment(Integer storyId) {
        if(commentMapper.selectCommentByStoId(storyId)!=null){
            return ResultUtil.setOK("获取成功",commentMapper.selectCommentByStoId(storyId));
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"获取失败",null);
        }
    }
}
