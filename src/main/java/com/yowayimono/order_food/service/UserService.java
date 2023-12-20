package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.LoginVo;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.UserInfo;
import com.yowayimono.order_food.vo.RegisterVo;

public interface UserService {


    Result Register(RegisterVo user);


    Result findUser(PageSelect page);
    Result Login(LoginVo user);



     Result updateUser(UserInfo user);

}
