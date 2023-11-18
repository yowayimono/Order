package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.service.UserService;
import com.yowayimono.order_food.vo.LoginVo;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.UserInfo;
import com.yowayimono.order_food.vo.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;



    @Operation(summary = "用户登录")
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result Login(@RequestBody LoginVo user) {
        return userservice.Login(user);
    }


    @Operation(summary = "注册用户")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result Register(@RequestBody UserVo user){
        return userservice.Register(user);

    }


    @Operation(summary = "更新用户信息")
    @RequestMapping(value = "UpdateInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result UpdateUser(@RequestBody UserInfo user) {
        return userservice.updateUser(user);
    }

    @Operation(summary = "分页查询用户")
    @RequestMapping(value = "/finduser",method = RequestMethod.POST)
    @ResponseBody
    public Result FindUser(@RequestBody PageSelect page){
        return userservice.findUser(page);
    }

    @Operation(summary = "测试接口")
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "hello,成功！";
    }



}
