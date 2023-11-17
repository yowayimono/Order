package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Tag;
import com.yowayimono.order_food.enitiy.Thing;
import com.yowayimono.order_food.enitiy.ThingTag;
import com.yowayimono.order_food.mapper.TagMapper;
import com.yowayimono.order_food.mapper.ThingMapper;
import com.yowayimono.order_food.mapper.ThingTagMapper;
import com.yowayimono.order_food.service.ThingTagService;
import com.yowayimono.order_food.vo.ThingTagVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThingTagServiceImpl implements ThingTagService {

    @Autowired
    private ThingTagMapper thingTagMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    ThingMapper thingMapper;
    private ModelMapper modelMapper;

    public ThingTagServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertThingTag(ThingTagVo thingTagVo) {
        try {
            ThingTag thingTag = modelMapper.map(thingTagVo, ThingTag.class);
            int result = thingTagMapper.insert(thingTag);
            if (result > 0) {
                return Result.success(666, "插入成功！", thingTag);
            } else {
                return Result.fail(4444, "插入失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "插入失败！");
        }
    }


    @Override
    public Result selectThingsByTagId(Long tagId) {
        try {
            QueryWrapper<ThingTag> wrapper = new QueryWrapper<>();
            wrapper.eq("tagId", tagId);
            List<ThingTag> thingTags = thingTagMapper.selectList(wrapper);

            List<Thing> things = new ArrayList<>();
            for (ThingTag thingTag : thingTags) {
                Thing thing = thingMapper.selectById(thingTag.getThingId());
                things.add(thing);
            }

            return Result.success(666, "查询成功！", things);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectTagsByThingId(Long thingId) {
        try {
            QueryWrapper<ThingTag> wrapper = new QueryWrapper<>();
            wrapper.eq("thingId", thingId);
            List<ThingTag> thingTags = thingTagMapper.selectList(wrapper);

            List<Tag> tags = new ArrayList<>();
            for (ThingTag thingTag : thingTags) {
                Tag tag = tagMapper.selectById(thingTag.getTagId());
                tags.add(tag);
            }

            return Result.success(666, "查询成功！", tags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectThingTagById(Long id) {
        try {
            ThingTag thingTag = thingTagMapper.selectById(id);
            if (thingTag != null) {
                return Result.success(666, "查询成功！", thingTag);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAllThingTags() {
        try {
            List<ThingTag> thingTags = thingTagMapper.selectList(null);
            return Result.success(666, "查询成功！", thingTags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectThingTagsByThingId(Long thingId) {
        try {
            QueryWrapper<ThingTag> wrapper = new QueryWrapper<>();
            wrapper.eq("thingId", thingId);
            List<ThingTag> thingTags = thingTagMapper.selectList(wrapper);
            return Result.success(666, "查询成功！", thingTags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectThingTagsByTagId(Long tagId) {
        try {
            QueryWrapper<ThingTag> wrapper = new QueryWrapper<>();
            wrapper.eq("tagId", tagId);
            List<ThingTag> thingTags = thingTagMapper.selectList(wrapper);
            return Result.success(666, "查询成功！", thingTags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateThingTag(ThingTagVo thingTagVo) {
        try {
            ThingTag thingTag = modelMapper.map(thingTagVo, ThingTag.class);
            int result = thingTagMapper.updateById(thingTag);
            if (result > 0) {
                return Result.success(666, "更新成功！", thingTag);
            } else {
                return Result.fail(4444, "更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "更新失败！");
        }
    }

    @Override
    public Result deleteThingTagById(Long id) {
        try {
            int result = thingTagMapper.deleteById(id);
            if (result > 0) {
                return Result.success(666, "删除成功！", id);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }
}
