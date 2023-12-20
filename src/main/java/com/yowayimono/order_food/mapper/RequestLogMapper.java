package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.RequestLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RequestLogMapper extends BaseMapper<RequestLog> {


    @Select("Select * from or_request_log limit #{start} , #{size}")
    List<RequestLog> selectByPage(Long current, Long size);
}
