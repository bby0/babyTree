package com.qfedu.babytree.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.qfedu.babytree.constan.SystemCon;
import com.qfedu.babytree.mapper.UsersLogMapper;
import com.qfedu.babytree.mapper.UsersMapper;
import com.qfedu.babytree.pojo.Users;
import com.qfedu.babytree.redis.RedisUtil;
import com.qfedu.babytree.service.SSOService;
import com.qfedu.babytree.token.Token;
import com.qfedu.babytree.token.TokenUtil;
import com.qfedu.babytree.util.ResultUtil;
import com.qfedu.babytree.util.StringUtil;
import com.qfedu.babytree.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class SSOServiceImpl implements SSOService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UsersLogMapper usersLogMapper;

//    @Autowired
//    private JedisUtil jedisUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public ResultBean login(String name, String password,String ip) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        System.out.println(name);
        //获取登录的用户对象
        Users user=usersMapper.selectByName(name);
        System.out.println("user : " + user);
        //校验用户名是否存在
        if(user!=null){
            if(Objects.equals(user.getUserPassword(),password)){
                //登录成功
                //生成令牌
                String token= TokenUtil.createToken(JSON.toJSONString(user),user.getUserId());
                //存储令牌到Redis
                //采用Hash类型 存储的键为固定字符串+Token 存储的值是对应用户信息的json字符串
                //jedisUtil.addHash(SystemCon.TOKENHASH,"token:"+token,JSON.toJSONString(user));
                ops.set(SystemCon.TOKENHASH, token);//1分钟过期
                //日志记录
                //usersLogMapper.insert(new UsersLog(user.getUserId(),"登录成功：令牌："+token,ip));
                //返回值需要携带生成Token和对应的登录信息
                return ResultUtil.setOK(token,user);
            }
        }
        return ResultUtil.setError(SystemCon.RERROR1,"登录失败",null);
    }

    @Override
    public ResultBean checkLogin(String token) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //String value=jedisUtil.getHash(SystemCon.TOKENHASH,"token:"+token);
        String value = ops.get(SystemCon.TOKENHASH);
        System.out.println("value : " + value);
        if(StringUtil.checkNoEmpty(value)){
            //Users user=JSON.parseObject(value,Users.class);
            Token tk = TokenUtil.parseToken(value);
            System.out.println(tk);
            return ResultUtil.setOK("登录有效",tk);

        }else{
            return ResultUtil.setError(SystemCon.RERROR1,"登录失效，请重新登录",null);
        }
    }

    @Override
    public ResultBean loginout(String token) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //jedisUtil.delHash(SystemCon.TOKENHASH,"token:"+token);
        redisUtil.del(SystemCon.TOKENHASH);//1分钟过期

        return ResultUtil.setOK("注销成功",null);
    }
}
