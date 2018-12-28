package com.qfedu.babytree.serviceImpl;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.FeedbackMapper;
import com.qfedu.babytree.mapper.NoticeMapper;
import com.qfedu.babytree.mapper.UsersLogMapper;
import com.qfedu.babytree.mapper.UsersMapper;
import com.qfedu.babytree.pojo.Feedback;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.pojo.UsersLog;
import com.qfedu.babytree.service.UserService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.util.UserUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UsersLogMapper usersLogMapper;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ResultBean save(Users user, String ip)
    {
        UsersLog usersLog = new UsersLog();

        ResultBean rb= ResultUtil.execOp(usersMapper.insert(user),"用户注册");
        System.out.println("新增用户："+user.getUserId());
        usersLog.setUid(user.getUserId());
        usersLog.setContent("完成注册"+user.getUserNickname());

        usersLogMapper.insert(usersLog);
        return rb;
    }


    @Override
    public ResultBean checkRepeat(String name) {
        Users user=usersMapper.selectByName(name);
        System.out.println(name);
        System.out.println("检查用户名"+user);
        if(user==null){
            return ResultUtil.setOK("OK",null);
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"已经存在",null);
        }
    }

    @Override
    public ResultBean selectByUserid(Integer userId) {

        return ResultUtil.setOK("OK",usersMapper.selectByPrimaryKey(userId));
    }

    @Override
    public ResultBean updataUserInfo(HttpServletRequest request, Users users) {
        users.setUserId(UserUtil.getUserId(request));
        System.out.println("user " + users);
        int i = usersMapper.updateByPrimaryKeySelective(users);

        return i > 0 ? ResultUtil.setOK("修改成功",usersMapper.updateByPrimaryKeySelective(users)) : ResultUtil.setError(SystemCon.RERROR1, "修改失败", null);
    }

    @Override
    public ResultBean insertSelective(Feedback feedback) {

        if(feedbackMapper.insertSelective(feedback)>0){
            return ResultUtil.setOK("获取成功",feedbackMapper.insertSelective(feedback));
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"获取失败",null);
        }
    }

    @Override
    public ResultBean addNotice(Integer noticeId, Integer userId) {


        if (usersMapper.checkNotice(noticeId,userId)==1) {

            return ResultUtil.setError(SystemCon.RERROR1,"不能重复关注哦~",null);
        } else {

            if(usersMapper.addNotice(noticeId,userId)>0){
                return ResultUtil.setOK("关注成功",1);
            }else {
                return ResultUtil.setError(SystemCon.RERROR1,"关注失败",null);
            }
        }

    }
}
