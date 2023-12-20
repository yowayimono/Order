package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yowayimono.order_food.enitiy.CollectProduct;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectProductMapper extends BaseMapper<CollectProduct> {

    // 插入一条记录
    @Insert("INSERT INTO or_collect (productId, userId) VALUES (#{productId}, #{userId})")
    int insertCollectProduct(@Param("productId") Long productId, @Param("userId") Long userId);

    // 根据 ID 删除记录
    @Delete("DELETE FROM or_collect WHERE id = #{id}")
    int deleteCollectProductById(@Param("id") Long id);


    // 更新记录
    @Update("UPDATE or_collect SET productId = #{productId}, userId = #{userId} WHERE id = #{id}")
    int updateCollectProduct(CollectProduct collectProduct);

    // 根据 ID 查询记录
    @Select("SELECT * FROM or_collect WHERE userId = #{userId}")
    List<CollectProduct> selectByUserId(@Param("userId") Long userId);


    @Select("SELECT * FROM or_collect WHERE id = #{id}")
    CollectProduct selectCollectProductById(@Param("id") Long id);

    // 根据条件查询记录列表
    @Select("SELECT * FROM or_collect WHERE ${ew.sqlSegment}")
    List<CollectProduct> selectCollectProductList(@Param(Constants.WRAPPER) Wrapper<CollectProduct> wrapper);


    @Select(" SELECT * FROM or_collect WHERE userid = #{userid} ORDER BY id")
    List<CollectProduct> getCollectProducts(Long userid);

    // 分页查询记录
    @Select("SELECT * FROM or_collect")
    List<CollectProduct> selectCollectProductPage(Page<CollectProduct> page);
}
