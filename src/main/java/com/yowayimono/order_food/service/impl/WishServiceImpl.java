package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Wish;

import com.yowayimono.order_food.mapper.WishMapper;

import com.yowayimono.order_food.service.WishService;

import com.yowayimono.order_food.vo.ThingWishVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishServiceImpl implements WishService {

    @Autowired
    private WishMapper ProductWishMapper;

    private ModelMapper modelMapper;

    public WishServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertProductWish(ThingWishVo Productwish) {
        try {
            Wish tw = modelMapper.map(Productwish, Wish.class);
            // tw.set(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
            int result = ProductWishMapper.insertProductWish(tw);
            if (result > 0) {
                return Result.success(666, "插入成功！");
            } else {
                return Result.fail(4444, "插入失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "插入失败！");
        }
    }

    @Override
    public Result selectProductWishById(Long id) {
        try {
            Wish wish = ProductWishMapper.selectProductWishById(id);
            if (wish != null) {
                return Result.success(666, "查询成功！", wish);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }


    @Override
    public Result selectProductWishesByUserId(Long userId) {
        try {
            List<Wish> wishes = ProductWishMapper.selectProductWishesByUserId(userId);
            return Result.success(666, "查询成功！", wishes);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectProductWishesByProductId(Long ProductId) {
        try {
            List<Wish> wishes = ProductWishMapper.selectProductWishesByProductId(ProductId);
            return Result.success(666, "查询成功！", wishes);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }



    @Override
    public Result deleteProductWishById(Long id) {
        try {
            int result = ProductWishMapper.deleteProductWishById(id);
            if (result > 0) {
                return Result.success(666, "删除成功！", id);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }

    @Override
    public Result deleteProductWishesByUserId(Long userId) {
        try {
            int result = ProductWishMapper.deleteProductWishesByUserId(userId);
            if (result > 0) {
                return Result.success(666, "删除成功！", userId);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }

    @Override
    public Result deleteProductWishesByProductId(Long ProductId) {
        try {
            int result = ProductWishMapper.deleteProductWishesByProductId(ProductId);
            if (result > 0) {
                return Result.success(666, "删除成功！", ProductId);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }


}
