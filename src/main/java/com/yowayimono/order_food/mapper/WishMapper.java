package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.Wish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WishMapper extends BaseMapper<Wish> {
    // Create
    @Insert("INSERT INTO or_Product_wish (ProductId, userId) VALUES (#{ProductId}, #{userId})")
    int insertProductWish(Wish wish);

    // Read
    @Select("SELECT * FROM or_Product_wish WHERE id = #{id}")
    Wish selectProductWishById(Long id);



    @Select("SELECT * FROM or_Product_wish WHERE userId = #{userId}")
    List<Wish> selectProductWishesByUserId(Long userId);

    @Select("SELECT * FROM or_Product_wish WHERE ProductId = #{ProductId}")
    List<Wish> selectProductWishesByProductId(Long ProductId);

    // Update
    @Update("UPDATE or_Product_wish SET ProductId = #{ProductId}, userId = #{userId} WHERE id = #{id}")
    int updateProductWish(Wish wish);

    // Delete
    @Delete("DELETE FROM or_Product_wish WHERE id = #{id}")
    int deleteProductWishById(Long id);

    @Delete("DELETE FROM or_Product_wish WHERE userId = #{userId}")
    int deleteProductWishesByUserId(Long userId);

    @Delete("DELETE FROM or_Product_wish WHERE ProductId = #{ProductId}")
    int deleteProductWishesByProductId(Long ProductId);
}
