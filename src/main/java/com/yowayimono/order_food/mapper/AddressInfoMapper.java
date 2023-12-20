package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.enitiy.AddressInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AddressInfoMapper extends BaseMapper<AddressInfo> {

    @Insert("INSERT INTO or_address (addrinfo, phone, title, deleteTime, description,  createTime, userId) " +
            "VALUES (#{addrinfo}, #{phone}, #{title}, #{deleteTime}, #{description}, #{createTime}, #{userId})")
    int insertAddress(AddressInfo address);

    @Select("SELECT * FROM or_address WHERE id = #{id}")
    AddressInfo selectAddressById(Long id);

    @Select("SELECT * FROM or_address WHERE userId = #{userId}")
    List<AddressInfo> selectAllAddressesByUserId(@Param("userId") Long userId);

    @Update("UPDATE or_address SET addrinfo = #{name}, phone = #{phone}, title = #{title}, deleteTime = #{deleteTime}, " +
            "description = #{description}, createTime = #{createTime}, userId = #{userId} " +
            "WHERE id = #{id}")
    int updateAddress(AddressInfo address);

    @Delete("DELETE FROM or_address WHERE id = #{id}")
    int deleteAddressById(Long id);

    @Select("SELECT * FROM or_address LIMIT #{offset}, #{limit}")
    List<AddressInfo> selectAddressesWithPagination(@Param("offset") Long offset, @Param("limit") Long limit);

    @Select("SELECT * FROM or_address WHERE userid = #{userId} LIMIT #{offset}, #{limit}")
    List<AddressInfo> selectPageUser(@Param("offset") Long offset, @Param("limit") Long limit, @Param("userid") Long userid);
    @Select("SELECT COUNT(*) FROM or_address WHERE userId = #{userId}")
    int countAddressesByUserId(@Param("userId") Long userId);


    @Select("SELECT * FROM or_address WHERE userId = #{userId}")
    List<AddressInfo> selectAddressesPage(Page<AddressInfo> page, @Param("userId") Long userId);
}