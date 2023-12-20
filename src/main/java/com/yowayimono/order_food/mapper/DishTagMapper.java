package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.DishTag;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;


@Mapper
public interface DishTagMapper extends BaseMapper<DishTag> {

        // Create
        int insert(DishTag dishTag);

        // Read
        @Select("SELECT * FROM or_dishtag WHERE deletetime IS NULL")
        List<DishTag> findAll();

        @Select("SELECT * FROM or_dishtag WHERE id = #{id} AND deletetime IS NULL")
        DishTag findById(@Param("id") Long id);

        @Select("SELECT * FROM or_dishtag WHERE title = #{title}")
        DishTag findByTitle(String title);
        @Select("SELECT * FROM or_dishtag WHERE deletetime IS NULL ORDER BY id LIMIT #{pageSize} OFFSET #{offset}")
        List<DishTag> findTags(Long pageSize, Long offset);



        @Select("SELECT * FROM or_dishtag WHERE deletetime IS NULL AND title LIKE CONCAT('%', #{searchTerm}, '%')")
        List<DishTag> findTagsByPartialMatch(String searchTerm);



        // Update
        @Update("  UPDATE or_dishtag\n" +
                "        SET title = #{title},\n" +
                "            description = #{description},\n" +
                "            createtime = #{createtime},\n" +
                "            deletetime = #{deletetime}\n" +
                "        WHERE id = #{id}")
        void update(DishTag dishtag);


        // Delete
        @Delete("DELETE FROM or_dishtag WHERE id = #{id} AND deletetime IS NULL")
        void deleteById(Long id);

        @Delete("DELETE FROM or_dishtag WHERE title = #{title} AND deletetime IS NULL")
        void deleteByTitle(String title);

}
