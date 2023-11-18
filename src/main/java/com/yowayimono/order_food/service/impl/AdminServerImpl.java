package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.core.utils.EncryptionUtils;
import com.yowayimono.order_food.core.utils.RedisUtils;
import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.mapper.AdminMapper;
import com.yowayimono.order_food.mapper.UserMapper;

import com.yowayimono.order_food.service.AdminService;
import com.yowayimono.order_food.vo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.yowayimono.order_food.core.validator.Validator.*;

@Service
public class AdminServerImpl implements AdminService {
    @Autowired
    AdminMapper adminmapper;
    @Autowired
    RedisUtils redisutils;

    @Autowired
    UserMapper userMapper;

    ModelMapper modelmapper;

    @Override
    public Result Register(UserVo user) {
        // 查询数据库，检查用户名是否已存在
        if (findUserByName(user.getUsername()) != null) {
            return Result.fail("用户名已存在");
        }

        if (!isValidUsername(user.getUsername())) {
            return Result.fail("用户名格式不正确");
        }

        if (!isValidPassword(user.getPassword())) {
            return Result.fail("密码格式不正确");
        }

        if (!isValidPhoneNumber(user.getMobile())) {
            return Result.fail("电话号码格式不正确");
        }

        // 执行注册逻辑
        AddrAdmin(user);

        return Result.success(user.getUsername());
    }


    @Override
    public Result Login(LoginVo user) {
        User u =  findUserByName(user.getUsername());

        if(u==null){
            return Result.fail(666,"用户不存在！");
        }

        if(!EncryptionUtils.checkPassWord(user.getPassword(),u.getPassword())) {
            return Result.fail(444,"密码错误！");
        }
        System.out.println(u);
        if(!u.getRole().equals("admin")){

            return Result.fail(233,"没有权限，非管理员用户!"+u.getRole());
        }

        if(redisutils.get(u.getId().toString())!=null){
            // 判断是否已经登录过，这里不判断很可
            return Result.fail(444,"已经登陆过了亲~");
        }

        UUID id = UUID.randomUUID();

        String token = "token_"+id.toString();

        redisutils.setEx( token,u.getId().toString(),30, TimeUnit.MINUTES);

        redisutils.setEx( u.getId().toString(),token,30, TimeUnit.MINUTES);

        return Result.success(new TokenAndUser(u.getId(),token,u.getUsername()));
    }



    private void AddrAdmin(UserVo user) {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(EncryptionUtils.sha256(user.getPassword()));
        u.setMobile(user.getMobile());
        u.setRole("admin"); //
        adminmapper.insert(u);
    }


    public User findUserByName(String username) {
        return userMapper.selectOne(new QueryWrapper<User>()
                .eq("username", username)
                .select("username", "password", "id", "avatar", "nickname","role")
                .last("limit 1"));
    }

    @Override
    public  Result findUser(PageSelect page){
        List<User> userlist = userMapper.findUsers(page.getPagesize(), page.getOffect());

        List<UserInfo> result = new ArrayList<>();
        for (User user : userlist) {
            UserInfo userInfo = modelmapper.map(user, UserInfo.class);
            result.add(userInfo);
        }

        return Result.success(result);
    }


}
