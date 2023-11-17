package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.ThingWish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ThingWishMapper extends BaseMapper<ThingWish> {
    // Create
    @Insert("INSERT INTO or_thing_wish (thingId, userId) VALUES (#{thingId}, #{userId})")
    int insertThingWish(ThingWish thingWish);

    // Read
    @Select("SELECT * FROM or_thing_wish WHERE id = #{id}")
    ThingWish selectThingWishById(Long id);



    @Select("SELECT * FROM or_thing_wish WHERE userId = #{userId}")
    List<ThingWish> selectThingWishesByUserId(Long userId);

    @Select("SELECT * FROM or_thing_wish WHERE thingId = #{thingId}")
    List<ThingWish> selectThingWishesByThingId(Long thingId);

    // Update
    @Update("UPDATE or_thing_wish SET thingId = #{thingId}, userId = #{userId} WHERE id = #{id}")
    int updateThingWish(ThingWish thingWish);

    // Delete
    @Delete("DELETE FROM or_thing_wish WHERE id = #{id}")
    int deleteThingWishById(Long id);

    @Delete("DELETE FROM or_thing_wish WHERE userId = #{userId}")
    int deleteThingWishesByUserId(Long userId);

    @Delete("DELETE FROM or_thing_wish WHERE thingId = #{thingId}")
    int deleteThingWishesByThingId(Long thingId);
}
