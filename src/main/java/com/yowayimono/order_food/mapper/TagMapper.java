package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.Tag;
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
        Tag findByTitle(String title);
        @Select("SELECT title FROM or_tag ORDER BY id LIMIT #{pageSize} OFFSET #{offset}")
        List<String> findTags(Long pageSize, Long offset);


        @Select("SELECT title FROM or_tag WHERE title LIKE CONCAT('%', #{searchTerm}, '%')")
        List<Tag> findTagsByPartialMatch(String searchTerm);


        // Update
        void update(Tag tag);

        // Delete
        void deleteById(Long id);
        void deleteByTitle(String title);

}
