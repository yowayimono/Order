package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.Tag;
import com.yowayimono.order_food.enitiy.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface TagMapper extends BaseMapper<Tag> {

        // Create
        int insert(Tag tag);

        // Read
        List<Tag> findAll();
        Tag findById(Long id);

        @Select("SELECT * FROM or_tag WHERE title = #{title}")
        Tag findByTitle(String title);
        @Select("SELECT * FROM or_tag ORDER BY id LIMIT #{pageSize} OFFSET #{offset}")
        List<Tag> findTags(Long pageSize, Long offset);


        @Select("SELECT * FROM or_tag WHERE title LIKE CONCAT('%', #{searchTerm}, '%')")
        List<Tag> findTagsByPartialMatch(String searchTerm);


        // Update
        void update(Tag tag);

        // Delete
        @Delete("DELETE FROM or_tag WHERE id = #{id}")
        void deleteById(Long id);

        @Delete("DELETE FROM or_tag WHERE title = #{title}")
        void deleteByTitle(String title);

}
