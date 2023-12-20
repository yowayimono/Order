package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.OrderStatus;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.core.utils.QRCodeGenerator;
import com.yowayimono.order_food.enitiy.Order;
import com.yowayimono.order_food.enitiy.OrderAndProduct;

import com.yowayimono.order_food.enitiy.Product;
import com.yowayimono.order_food.mapper.OrderAndProductMapper;
import com.yowayimono.order_food.mapper.OrderMapper;

import com.yowayimono.order_food.mapper.ProductMapper;
import com.yowayimono.order_food.service.OrderUserService;
import com.yowayimono.order_food.vo.OrderVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderUserServiceImpl implements OrderUserService {
    @Autowired
    ProductMapper ProductMapper;

    @Autowired
    OrderAndProductMapper OTMapper;

    @Autowired
    OrderMapper orderMapper;

    private ModelMapper modelMapper;

    @Override
    public Result selectAllProducts() {
        try {
            QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", "上架"); // 添加查询条件

            List<Product> Products = ProductMapper.selectList(queryWrapper);
            return Result.success(666, "查询成功！", Products);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

/*

    @Override
    public Result purchase(OrderVo orderVo) {
        try {
            // 先创建订单
            Order order = new Order();
            order.setUserId(orderVo.getUserId());
            // 设置其他订单属性...

            orderMapper.insert(order);

            // 再添加商品和订单的关联
            if (orderVo.getProducts() != null) {
                for (Long ProductId : orderVo.getProducts()) {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrderId(order.getId());
                    orderProduct.setProductId(ProductId);
                    orderProduct.setQuantity(1); // 设置商品数量，这里可以根据需要传递的信息进行设置
                    OTMapper.insert(orderProduct);

                }
            }

            // 可以添加其他业务逻辑...

            return Result.success(666, "购买成功！", order);
        } catch (Exception e) {
            // log.error("购买商品失败", e);
            return Result.fail(4444, "购买失败！");
        }
    }



 */

    @Override
    public Result selectProductsWithPagination(Long current, Long size) {
        try {
            Page<Product> page = new Page<>(current, size);

            // 添加查询条件
            QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", "上架");

            IPage<Product> resultPage = ProductMapper.selectPage(page, queryWrapper);

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

                if (order.getProducts() != null) {
                    for (Long ProductId : order.getProducts()) {
                        OrderAndProduct orderAndProduct = new OrderAndProduct();
                        orderAndProduct.setOrderId(or.getId());
                        orderAndProduct.setProductId(ProductId);
                        orderAndProduct.setQuantity(1); // 设置商品数量，这里可以根据需要传递的信息进行设置
                        OTMapper.insert(orderAndProduct);
                    }
                }


                int result = orderMapper.insert(or);




                BufferedImage qrCode = QRCodeGenerator.createImage("支付成功！");



                Map<String,Object> data = new HashMap<>();
                data.put("qrcode", qrCode);
                data.put("order",order);
                if (result > 0) {
                    return Result.success(666, "订单创建成功！", data);
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
