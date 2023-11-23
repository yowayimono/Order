package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.OrderStatus;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Order;
import com.yowayimono.order_food.enitiy.Thing;
import com.yowayimono.order_food.mapper.OrderMapper;
import com.yowayimono.order_food.mapper.ThingMapper;
import com.yowayimono.order_food.service.OrderService;
import com.yowayimono.order_food.service.OrderUserService;
import com.yowayimono.order_food.vo.OrderVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUserServiceImpl implements OrderUserService {
    @Autowired
    ThingMapper thingMapper;

    @Autowired
    OrderMapper orderMapper;

    private ModelMapper modelMapper;

    @Override
    public Result selectAllThings() {
        try {
            QueryWrapper<Thing> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", "上架"); // 添加查询条件

            List<Thing> things = thingMapper.selectList(queryWrapper);
            return Result.success(666, "查询成功！", things);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectThingsWithPagination(Long current, Long size) {
        try {
            Page<Thing> page = new Page<>(current, size);

            // 添加查询条件
            QueryWrapper<Thing> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", "上架");

            IPage<Thing> resultPage = thingMapper.selectPage(page, queryWrapper);

            return Result.success(666, "查询成功！", resultPage);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }



        @Override
        public Result insertOrder(OrderVo order) {
            try {
                Order or = modelMapper.map(order, Order.class);
                System.out.println(or);
                int result = orderMapper.insert(or);
                if (result > 0) {
                    return Result.success(666, "订单创建成功！", order);
                } else {
                    return Result.fail(4444, "订单创建失败！");
                }
            } catch (Exception e) {
                return Result.fail(4444, "订单创建失败！");
            }
        }

        @Override
        public Result selectOrderById(Long id) {
            try {
                Order order = orderMapper.selectById(id);
                if (order != null) {
                    return Result.success(666, "查询成功！", order);
                } else {
                    return Result.fail(4444, "未找到对应订单！");
                }
            } catch (Exception e) {
                return Result.fail(4444, "查询失败！");
            }
        }

        @Override
        public Result selectAllOrders(Long id) {
            try {
                QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("userid", id);
                List<Order> orders = orderMapper.selectList(null);
                return Result.success(666, "查询成功！", orders);
            } catch (Exception e) {
                return Result.fail(4444, "查询失败！");
            }
        }

        @Override
        public Result updateOrder(OrderVo order) {
            try {
                Order or = modelMapper.map(order, Order.class);
                int result = orderMapper.updateById(or);
                if (result > 0) {
                    return Result.success(666, "订单更新成功！", order);
                } else {
                    return Result.fail(4444, "订单更新失败！");
                }
            } catch (Exception e) {
                return Result.fail(4444, "订单更新失败！");
            }
        }

        @Override
        public Result deleteOrderById(Long id) {
            try {
                int result = orderMapper.deleteById(id);
                if (result > 0) {
                    return Result.success(666, "订单删除成功！", id);
                } else {
                    return Result.fail(4444, "订单删除失败！");
                }
            } catch (Exception e) {
                return Result.fail(4444, "订单删除失败！");
            }
        }
    @Override
    public Result updateOrderPaymentStatus(Long orderId, String newStatus) {
        try {
            Order order = orderMapper.selectById(orderId);
            if (order != null) {
                OrderStatus status = OrderStatus.fromValue(newStatus);
                order.setStatus(status);
                int result = orderMapper.updateById(order);
                if (result > 0) {
                    return Result.success(666, "订单支付状态更新成功！", order);
                } else {
                    return Result.fail(4444, "订单支付状态更新失败！");
                }
            } else {
                return Result.fail(4444, "未找到对应订单！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "订单支付状态更新失败！");
        }
    }


}
