package com.qfedu.babytree.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.CommentMapper;
import com.qfedu.babytree.mapper.ImgsMapper;
import com.qfedu.babytree.mapper.StoryMapper;
import com.qfedu.babytree.pojo.Comment;
import com.qfedu.babytree.pojo.Imgs;
import com.qfedu.babytree.pojo.Story;
import com.qfedu.babytree.service.StoryService;
import com.qfedu.babytree.util.OSSUtil;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResponseVo;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryMapper storyMapper;

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ImgsMapper imgsMapper;
    @Autowired
    private OSSUtil ossUtil;


    @Override
    public ResponseVo<Story> getStory(Integer uid, Integer pageNum, Integer pageSize) {

        Integer pageNum1 = 1;
        Integer pageSize1 = 5;

        if (pageNum == null || pageSize == null) {

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
        if (storyMapper.giveLike(uid, tid) <= 0) {
            return ResultUtil.setOK("点赞成功", null);
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "点赞失败", null);
        }

    }

    @Override
    public ResultBean getMySpaceInfo(Integer uid) {


        if (storyMapper.getMySpaceinfo(uid) != null) {
            return ResultUtil.setOK("获取成功", storyMapper.getMySpaceinfo(uid));
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "获取失败", null);
        }
    }

    @Override
    public ResultBean getMyStory(Integer uid) {
        if (storyMapper.getmyStory(uid) != null) {
            return ResultUtil.setOK("获取成功", storyMapper.getmyStory(uid));
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "获取失败", null);
        }
    }

    @Override
    public ResultBean doComment(Comment comment) {
        if (commentMapper.doComment(comment) > 0) {
            return ResultUtil.setOK("评论成功", null);
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "评论失败", null);
        }
    }

    /**
     * 获取说说详情
     * @param stoId
     * @return
     */
    @Override
    public ResultBean getStoryDetail(Integer stoId) {

//        Integer stoUserid = Integer.valueOf(stoUserId);
//        Integer stoid = Integer.valueOf(stoUserId);

        //List<Story> data = storyMapper.getStoryDetail(stoUserId,stoId);
        System.out.println(storyMapper.getStoryDetail( stoId));

        if (storyMapper.getStoryDetail(stoId) != null) {
            return ResultUtil.setOK("获取成功", storyMapper.getStoryDetail(stoId));
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "获取失败", null);
        }
    }

    @Override
    public ResultBean getComment(Integer storyId) {
        System.out.println(storyId);
        System.out.println("评论"+commentMapper.selectCommentByStoId(storyId));
        if (commentMapper.selectCommentByStoId(storyId) != null) {
            return ResultUtil.setOK("获取成功", commentMapper.selectCommentByStoId(storyId));
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "获取失败", null);
        }
    }

    @Override
    public ResultBean addStory(Story story, MultipartFile[] file) throws IOException {


        storyMapper.insert(story);
        List<Imgs> arr = new ArrayList<Imgs>();

        for (int i = 0; i < file.length; i++) {

            String path = ossUtil.fileUp(file[i].getOriginalFilename(), file[i].getBytes());
            System.out.println("文件地址:" + path);

            Imgs img = new Imgs();
            img.setImgUrl(path);
            img.setStoryId(story.getStoId());
            arr.add(img);

            imgsMapper.insert(img);

        }
        if (storyMapper.insertSelective(story) > 0) {

            return ResultUtil.setOK("添加成功", storyMapper.insertSelective(story));
        } else {
            return ResultUtil.setError(SystemCon.RERROR1, "添加失败", null);
        }
    }

    @Override
    public ResponseVo<Story> getAllStory(Integer pageNum, Integer pageSize) {

        Integer pageNum1 = 1;
        Integer pageSize1 = 5;

        if (pageNum == null || pageSize == null) {

            pageNum = pageNum1;
            pageSize = pageSize1;

        }


        PageHelper.startPage(pageNum, pageSize);
        List<Story> list = storyMapper.selectAllStory();
        PageInfo<Story> page = new PageInfo<Story>(list);
        ResponseVo<Story> vo = ResponseVo.OK();

        List<Story> count = storyMapper.selectAllStory();
        System.out.println(count.size());

        vo.setData(page.getList());
        vo.setCount(count.size());

        return vo;


    }
}
