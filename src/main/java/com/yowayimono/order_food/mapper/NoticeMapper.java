package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yowayimono.order_food.enitiy.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NoticeMapper extends BaseMapper<Notice> {
    // Create: Insert a new notice
    @Insert("INSERT INTO or_notice (title, content, createTime) " +
            "VALUES (#{title}, #{content}, #{createTime})")
    int insertNotice(Notice notice);

    // Read: Select a notice by its ID
    @Select("SELECT * FROM or_notice WHERE id = #{id}")
    Notice selectNoticeById(Long id);

    // Read: Select all notices
    @Select("SELECT * FROM or_notice")
    List<Notice> selectAllNotices();

    // Update: Update an existing notice
    @Update("UPDATE or_notice SET title = #{title}, content = #{content}, createTime = #{createTime} " +
            "WHERE id = #{id}")
    int updateNotice(Notice notice);

    // Delete: Delete a notice by its ID
    @Delete("DELETE FROM or_notice WHERE id = #{id}")
    int deleteNoticeById(Long id);
}
