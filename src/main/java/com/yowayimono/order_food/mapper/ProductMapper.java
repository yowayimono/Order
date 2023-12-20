package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yowayimono.order_food.enitiy.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    @Insert("INSERT INTO or_Product (title, nickname, sex, address, cover, description, price, createTime, classificationId) " +
            "VALUES (#{title}, #{nickname}, #{sex}, #{address}, #{cover}, #{description}, #{price}, #{createTime}, #{classificationId})")
    int insertProduct(Product Product);

    @Select("SELECT * FROM or_Product limit #{pagesize} offset #{offect}")
    List<Product> getByPage(Long pagesize, Long offect);

    @Select("SELECT COUNT(*) FROM or_Product")
    int countProduct();
}
