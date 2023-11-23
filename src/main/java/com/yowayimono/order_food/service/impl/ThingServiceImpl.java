package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Thing;
import com.yowayimono.order_food.mapper.ThingMapper;
import com.yowayimono.order_food.service.ThingService;
import com.yowayimono.order_food.vo.ThingVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ThingServiceImpl implements ThingService {

    @Autowired
    private ThingMapper thingMapper;

    private ModelMapper modelMapper;

    public ThingServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertThing(ThingVo thingVo) {
        try {
            System.out.println(thingVo.toString());
            Thing thing = modelMapper.map(thingVo, Thing.class);
            thing.setCreateTime(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
            System.out.println(thing.toString());
            int result = thingMapper.insert(thing);
            if (result > 0) {
                return Result.success(666, "插入成功！", thing);
            } else {
                return Result.fail(44444, "插入失败！");
            }
        } catch (Exception e) {
            System.out.println(e);
            return Result.fail(4444, "插入失败！");
        }
    }

    @Override
    public Result selectThingById(Long id) {
        try {
            Thing thing = thingMapper.selectById(id);
            if (thing != null) {
                return Result.success(666, "查询成功！", thing);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAllThings() {
        try {
            List<Thing> things = thingMapper.selectList(null);
            return Result.success(666, "查询成功！", things);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateThing(ThingVo thingVo) {
        try {
            Thing thing = modelMapper.map(thingVo, Thing.class);
            int result = thingMapper.updateById(thing);
            if (result > 0) {
                return Result.success(666, "更新成功！", thing);
            } else {
                return Result.fail(4444, "更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "更新失败！");
        }
    }

    @Override
    public Result deleteThingById(Long id) {
        try {
            int result = thingMapper.deleteById(id);
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
    public Result updateThingStatus(Long thingId, String status) {
        try {
            Thing thing = thingMapper.selectById(thingId);
            if (thing == null) {
                return Result.fail(4444, "商品不存在！");
            }

            // 更新商品状态
            thing.setStatus(status);
            int result = thingMapper.updateById(thing);

            if (result > 0) {
                return Result.success(666, "商品状态更新成功！", thing);
            } else {
                return Result.fail(4444, "商品状态更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "商品状态更新失败！");
        }
    }
    @Override
    public Result selectThingsWithPagination(Long current, Long size) {
        try {
            Page<Thing> page = new Page<>(current, size);
            IPage<Thing> resultPage = thingMapper.selectPage(page, null);

            return Result.success(666, "查询成功！", resultPage);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
}
