package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.ThingVo;

public interface ThingService {
    Result insertThing(ThingVo thingVo);

    Result selectThingById(Long id);

    Result selectAllThings();

    Result updateThing(ThingVo thingVo);

    Result deleteThingById(Long id);
    Result updateThingStatus(Long thingId, String status);

    Result selectThingsWithPagination(Long current, Long size);
}
