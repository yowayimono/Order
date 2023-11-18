package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.ThingWish;
import com.yowayimono.order_food.mapper.ThingWishMapper;
import com.yowayimono.order_food.service.ThingWishService;
import com.yowayimono.order_food.vo.ThingWishVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ThingWishServiceImpl implements ThingWishService {

    @Autowired
    private ThingWishMapper thingWishMapper;

    private ModelMapper modelMapper;

    public ThingWishServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertThingWish(ThingWishVo thingwish) {
        try {
            ThingWish tw = modelMapper.map(thingwish, ThingWish.class);
            // tw.set(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
            int result = thingWishMapper.insertThingWish(tw);
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
    public Result selectThingWishById(Long id) {
        try {
            ThingWish thingWish = thingWishMapper.selectThingWishById(id);
            if (thingWish != null) {
                return Result.success(666, "查询成功！", thingWish);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }


    @Override
    public Result selectThingWishesByUserId(Long userId) {
        try {
            List<ThingWish> thingWishes = thingWishMapper.selectThingWishesByUserId(userId);
            return Result.success(666, "查询成功！", thingWishes);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectThingWishesByThingId(Long thingId) {
        try {
            List<ThingWish> thingWishes = thingWishMapper.selectThingWishesByThingId(thingId);
            return Result.success(666, "查询成功！", thingWishes);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }



    @Override
    public Result deleteThingWishById(Long id) {
        try {
            int result = thingWishMapper.deleteThingWishById(id);
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
    public Result deleteThingWishesByUserId(Long userId) {
        try {
            int result = thingWishMapper.deleteThingWishesByUserId(userId);
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
    public Result deleteThingWishesByThingId(Long thingId) {
        try {
            int result = thingWishMapper.deleteThingWishesByThingId(thingId);
            if (result > 0) {
                return Result.success(666, "删除成功！", thingId);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }


}
