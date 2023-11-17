package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.ThingTag;
import com.yowayimono.order_food.vo.ThingTagVo;

public interface ThingTagService {
    Result insertThingTag(ThingTagVo thingTagVo);

    Result selectThingTagById(Long id);

    Result selectAllThingTags();

    Result selectThingTagsByThingId(Long thingId);

    Result selectThingTagsByTagId(Long tagId);

    Result updateThingTag(ThingTagVo thingTagVo);

    Result selectThingsByTagId(Long tagId);

    Result selectTagsByThingId(Long thingId);

    Result deleteThingTagById(Long id);
}
