package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.CommentVo;

public interface CommentService {
    Result insertComment(CommentVo commentVo);

    Result selectCommentById(Long id);

    Result selectAllComments();

    Result selectCommentsByThingId(Long thingId);

    Result updateComment(CommentVo commentVo);

    Result deleteCommentById(Long id);

    Result countCommentsByThingId(Long thingId);
}
