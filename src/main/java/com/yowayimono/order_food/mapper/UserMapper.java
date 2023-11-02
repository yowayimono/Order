package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM or_user ORDER BY id LIMIT #{pageSize} OFFSET #{offset}")
    List<User> findUsers(@Param("pageSize") Long pageSize, @Param("offset") Long offset);
}
