package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM or_user ORDER BY id LIMIT #{pageSize} OFFSET #{offset}")
    List<User> findUsers(@Param("pageSize") Long pageSize, @Param("offset") Long offset);

    @Select("SELECT * FROM or_user WHERE id = #{id}")
    User findUserById(int id);
    @Select("SELECT username, password, id, avatar, nickname, role FROM or_user WHERE username = #{username} LIMIT 1")
    User findUserByName(@Param("username") String username);
}
