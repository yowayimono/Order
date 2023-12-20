package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.Categorize;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface GategorizeMapper extends BaseMapper<Categorize> {

    // Add a method to insert a new classification
    @Insert("INSERT INTO or_classification (title, createTime) VALUES (#{title}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertClassification(Categorize categorize);

    // Add a method to retrieve a classification by its ID
    @Select("SELECT * FROM or_classification WHERE id = #{id}")
    Categorize selectClassificationById(Long id);

    @Select("SELECT * FROM or_classification WHERE title = #{title}")
    Categorize selectClassificationByTitle(String title);

    // Add a method to retrieve all classifications
    @Select("SELECT * FROM or_classification")
    List<Categorize> selectAllClassifications();

    // Add a method to update a classification
    @Update("UPDATE or_classification SET title = #{title}, createTime = #{createTime} WHERE id = #{id}")
    int updateClassification(Categorize categorize);

    // Add a method to delete a classification by its ID
    @Delete("DELETE FROM or_classification WHERE id = #{id}")
    int deleteClassificationById(Long id);

    @Delete("DELETE FROM or_classification WHERE title = #{title}")
    int deleteClassificationByTitle(String Title);

    // Add a method to retrieve a paginated list of classifications
    @Select("SELECT * FROM or_classification LIMIT #{limit}, OFFECT #{offset}")
    List<Categorize> selectClassificationsWithPagination(@Param("offset") Long offset, @Param("limit") Long limit);

    // Add a method to count the total number of classifications
    @Select("SELECT COUNT(*) FROM or_classification")
    int countClassifications();
}
