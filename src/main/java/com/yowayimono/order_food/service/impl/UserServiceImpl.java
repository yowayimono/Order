package com.yowayimono.order_food.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.core.utils.EncryptionUtils;
import com.yowayimono.order_food.core.utils.JwtUtils;
import com.yowayimono.order_food.core.utils.RedisUtils;
import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.mapper.UserMapper;
import com.yowayimono.order_food.service.UserService;
import com.yowayimono.order_food.vo.*;
import org.apache.ibatis.annotations.Select;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.yowayimono.order_food.core.validator.Validator.*;


@Service

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper usermapper;
    @Autowired
    RedisUtils redisutils;


    ModelMapper modelmapper;
    public UserServiceImpl() {
        modelmapper = new ModelMapper();
    }
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
        AddrUser(user);

        return Result.success(user.getUsername());
    }


    @Override
    public Result Login(LoginVo user) {
        User u =  findUserByName(user.getUsername());

        if(u==null){
            return Result.fail(666,"用户不存在！");
        }

        if(!EncryptionUtils.checkPassWord(user.getUsername(),u.getPassword())) {
            return Result.fail(444,"密码错误！");
        }

        String token = JwtUtils.createToken(u);

        redisutils.setEx("TOKEN_"+token, JSON.toJSONString(u),3600*24*4, TimeUnit.DAYS);

        return Result.success(new TokenAndUser(token,u.getUsername()));
    }



    private void AddrUser(UserVo user) {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(EncryptionUtils.sha256(user.getUsername()));
        u.setMobile(user.getMobile());
        usermapper.insert(u);
    }


    public User findUserByName(String username) {
        return usermapper.selectOne(new QueryWrapper<User>()
                .eq("username", username)
                .select("username", "password", "id", "avatar", "nickname")
                .last("limit 1"));
    }

    @Override
    public  Result findUser(PageSelect page){
        List<User> userlist = usermapper.findUsers(page.getPagesize(), page.getOffect());

        List<UserInfo> result = new ArrayList<>();
        for (User user : userlist) {
            UserInfo userInfo = modelmapper.map(user, UserInfo.class);
            result.add(userInfo);
        }

        return Result.success(result);
    }


    @Select("SELECT * FROM or_user WHERE id = #{id}")
    public User findUserById(int id) {
        return usermapper.selectOne(new QueryWrapper<User>()
                .eq("id", id));
    }
    @Override
    public Result updateUser(UserInfo user) {
        String username = user.getUsername(); // 获取用户ID
        // 构建更新的字段映射
        Map<String, Object> updateFields = new HashMap<>();

        // 使用反射获取所有字段
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(user);
                if (value != null) {
                    updateFields.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // 更新用户信息
        if (!updateFields.isEmpty()) {
            // 构建更新条件
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("username", username);
            // 执行更新操作
            User u =findUserByName(username);

            u=modelmapper.map(user,u.getClass());
            usermapper.update(u, updateWrapper);
        }
        return Result.success("更新成功！");
    }

}
