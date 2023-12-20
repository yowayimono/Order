package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.ErrorLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ErrorLogMapper extends BaseMapper<ErrorLog> {

    @Select("SELECT * FROM or_error_log LIMIT #{start}, #{size}")
    List<ErrorLog> selectByPage(@Param("start") Long start, @Param("size") Long size);
}
