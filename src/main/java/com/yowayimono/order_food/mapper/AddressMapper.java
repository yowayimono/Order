package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.enitiy.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AddressMapper extends BaseMapper<Address> {

    @Insert("INSERT INTO or_address (name, mobile, title, deleteTime, description, def, createTime, userId) " +
            "VALUES (#{name}, #{mobile}, #{title}, #{deleteTime}, #{description}, #{def}, #{createTime}, #{userId})")
    int insertAddress(Address address);

    @Select("SELECT * FROM or_address WHERE id = #{id}")
    Address selectAddressById(Long id);

    @Select("SELECT * FROM or_address WHERE userId = #{userId}")
    List<Address> selectAllAddressesByUserId(@Param("userId") Long userId);

    @Update("UPDATE or_address SET name = #{name}, mobile = #{mobile}, title = #{title}, deleteTime = #{deleteTime}, " +
            "description = #{description}, def = #{def}, createTime = #{createTime}, userId = #{userId} " +
            "WHERE id = #{id}")
    int updateAddress(Address address);

    @Delete("DELETE FROM or_address WHERE id = #{id}")
    int deleteAddressById(Long id);

    @Select("SELECT * FROM or_address LIMIT #{offset}, #{limit}")
    List<Address> selectAddressesWithPagination(@Param("offset") Long offset, @Param("limit") Long limit);

    @Select("SELECT COUNT(*) FROM or_address WHERE userId = #{userId}")
    int countAddressesByUserId(@Param("userId") Long userId);


    @Select("SELECT * FROM or_address WHERE userId = #{userId}")
    IPage<Address> selectAddressesPage(Page<Address> page, @Param("userId") Long userId);
}