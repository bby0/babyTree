package com.qfedu.babytree.serviceImpl;

import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.UsersLogMapper;
import com.qfedu.babytree.mapper.UsersMapper;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.pojo.UsersLog;
import com.qfedu.babytree.service.UserService;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UsersLogMapper usersLogMapper;

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
}
