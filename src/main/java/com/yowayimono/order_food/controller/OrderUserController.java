package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.OrderAdminService;
import com.yowayimono.order_food.service.OrderUserService;
import com.yowayimono.order_food.service.ProductService;
import com.yowayimono.order_food.vo.OrderVo;
import com.yowayimono.order_food.vo.PageSelect;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "用户订单管理管理")
@RequestMapping(value = "/user/order")
public class OrderUserController {
    @Autowired
    ProductService ProductService;

    @Autowired
    private OrderUserService orderService;
    @Operation(summary = "下单一个订单对应多个商品")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertOrder(@RequestBody OrderVo order) {
        return orderService.insertOrder(order);
    }

    @Operation(summary = "根据ID查询订单")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getOrderById(@PathVariable Long id) {
        return orderService.selectOrderById(id);
    }

    @Operation(summary = "查询所有订单")
    @RequestMapping(value = "/getAll/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllOrders(@PathVariable Long id) {
        return orderService.selectAllOrders(id);
    }

    @Operation(summary = "更新订单")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateOrder(@RequestBody OrderVo order) {
        return orderService.updateOrder(order);
    }

    @Operation(summary = "删除订单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrderById(id);
    }
    @Operation(summary = "更新订单支付状态")
    @RequestMapping(value = "/updatePaymentStatus/{orderId}/{newStatus}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateOrderPaymentStatus(@PathVariable Long orderId, @PathVariable String newStatus) {
        return orderService.updateOrderPaymentStatus(orderId, newStatus);
    }

    /*
    @Operation(summary = "用户购买商品")
    @PostMapping("/purchase")
    @ResponseBody
    public Result purchase(@RequestBody OrderVo orderVo) {
        return orderService.purchase(orderVo);
    }

     */


    @Operation(summary = "获取所有Products")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllProducts() {
        return ProductService.selectAllProducts();
    }

    @Operation(summary = "分页查询Products")
    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductsByPage(@RequestBody PageSelect page) {
        return ProductService.selectProductsWithPagination(page);
    }
}
