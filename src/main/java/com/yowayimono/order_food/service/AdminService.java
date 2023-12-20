package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.vo.LoginVo;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.RegisterVo;

public interface AdminService {
    Result Login(LoginVo user);
    Result Register(RegisterVo user);
    Result findUser(PageSelect page);

    User findUserByName(String name);
}
