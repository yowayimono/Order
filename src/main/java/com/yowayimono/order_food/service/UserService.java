package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.vo.LoginVo;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.UserInfo;
import com.yowayimono.order_food.vo.UserVo;

public interface UserService {


    Result Register(UserVo user);


    Result findUser(PageSelect page);
    Result Login(LoginVo user);

    Result updateUser(UserInfo user);



}
