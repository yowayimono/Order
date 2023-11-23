package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.AdminService;
import com.yowayimono.order_food.service.UserService;
import com.yowayimono.order_food.vo.LoginVo;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "管理员操作")
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Operation(summary = "管理员登录")
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result Login(@RequestBody LoginVo user) {
        return adminService.Login(user);
    }


    @Operation(summary = "添加管理员")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result Register(@RequestBody UserVo user){
        return adminService.Register(user);
    }

    @Operation(summary = "分页查询用户")
    @RequestMapping(value = "/finduser",method = RequestMethod.POST)
    @ResponseBody
    public Result FindUser(@RequestBody PageSelect page){
        return adminService.findUser(page);
    }

}
