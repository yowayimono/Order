package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.CommentVo;

public interface CommentService {
    Result insertComment(CommentVo commentVo);

    Result selectCommentById(Long id);

    Result selectAllComments();

    Result selectCommentsByProductId(Long ProductId);

    Result updateComment(CommentVo commentVo);

    Result deleteCommentById(Long id);

    Result countCommentsByProductId(Long ProductId);

    Result likeComment(Long commentId, Long userId);

    Result getLikedUsers(Long commentId);
}
