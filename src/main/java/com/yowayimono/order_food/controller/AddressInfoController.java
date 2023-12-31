package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.AddressInfoService;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.PageSelectAndUser;
import com.yowayimono.order_food.vo.AddressVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "用户订餐地址")
@RequestMapping(value = "/user/address")
public class AddressInfoController {

    @Autowired
    private AddressInfoService addressInfoService;

    @Operation(summary = "添加订餐地址")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertAddress(@RequestBody AddressVo addressVo) {
        return addressInfoService.insertAddress(addressVo);
    }

    @Operation(summary = "获取地址详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getAddressById(@PathVariable Long id) {
        return addressInfoService.selectAddressById(id);
    }

    @Operation(summary = "获取某个用户所有订餐地址")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllAddressesByUserId(Long id) {
        return addressInfoService.selectAllAddressesByUserId(id);
    }

    @Operation(summary = "更新地址信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateAddress(@RequestBody AddressVo addressVo) {
        return addressInfoService.updateAddress(addressVo);
    }

    @Operation(summary = "删除地址")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteAddressById(@PathVariable Long id) {
        return addressInfoService.deleteAddressById(id);
    }

    @Operation(summary = "分页查询地址")
    @RequestMapping(value = "/findWithPagination", method = RequestMethod.POST)
    @ResponseBody
    public Result findAddressesWithPagination(@RequestBody PageSelect page) {
        return addressInfoService.selectAddressesWithPagination(page);
    }

    @Operation(summary = "统计用户地址数量")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public Result countAddresses(@Param("userid") Long id) {
        return addressInfoService.countAddressesByUserId(id);
    }

    @Operation(summary = "分页查询用户地址")
    @RequestMapping(value = "/findAddressesPage", method = RequestMethod.POST)
    @ResponseBody
    public Result findAddressesPage(@RequestBody PageSelectAndUser page) {
        return addressInfoService.selectAddressesPage(page.getOffect(), page.getPagesize(), page.getId());
    }

    // Additional endpoints for your Address entity can be added here

}
