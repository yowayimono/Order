package com.yowayimono.order_food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.enitiy.Comment;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    // Create: Insert a new comment
    @Insert("INSERT INTO or_comment (content, commentTime, likeCount, userId, thingId, deleteTime) " +
            "VALUES (#{content}, #{commentTime}, #{likeCount}, #{userId}, #{thingId}, #{deleteTime})")
    int insertComment(Comment comment);

    // Read: Select a comment by its ID
    @Select("SELECT * FROM or_comment WHERE id = #{id}")
    Comment selectCommentById(Long id);

    // Read: Select all comments
    @Select("SELECT * FROM or_comment")
    List<Comment> selectAllComments();

    // Update: Update an existing comment
    @Update("UPDATE or_comment SET content = #{content}, commentTime = #{commentTime}, " +
            "likeCount = #{likeCount}, userId = #{userId}, thingId = #{thingId}, deleteTime = #{deleteTime} " +
            "WHERE id = #{id}")
    int updateComment(Comment comment);

    // Delete: Delete a comment by its ID
    @Delete("DELETE FROM or_comment WHERE id = #{id}")
    int deleteCommentById(Long id);

    // Read: Select comments with pagination
    @Select("SELECT * FROM or_comment LIMIT #{offset}, #{limit}")
    List<Comment> selectCommentsWithPagination(@Param("offset") int offset, @Param("limit") int limit);

    // Read: Select comments with pagination using MyBatis Plus IPage
    @Select("SELECT * FROM or_comment")
    IPage<Comment> selectCommentsPage(Page<Comment> page);

    // Read: Select comments by ThingId
    @Select("SELECT * FROM or_comment WHERE thingId = #{thingId}")
    Comment selectCommentByThingId(@Param("thingId") Long thingId);
}