package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.CommentService;
import com.yowayimono.order_food.vo.CommentVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

@RestController
@Tag(name = "评论管理")
@RequestMapping(value = "/user/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Operation(summary = "添加Comment")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result insertComment(@RequestBody CommentVo commentVo) {
        return commentService.insertComment(commentVo);
    }

    @Cacheable("comments")
    @Operation(summary = "获取Comment详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getCommentById(@PathVariable Long id) {
        return commentService.selectCommentById(id);
    }

    @Cacheable("comments")
    @Operation(summary = "获取某个Product下的所有Comments")
    @RequestMapping(value = "/getByProductId/{ProductId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getCommentsByProductId(@PathVariable Long ProductId) {
        return commentService.selectCommentsByProductId(ProductId);
    }

    @Operation(summary = "统计某个Product下的评论数")
    @RequestMapping(value = "/countByProductId/{ProductId}", method = RequestMethod.GET)
    @ResponseBody
    public Result countCommentsByProductId(@PathVariable Long ProductId) {
        return commentService.countCommentsByProductId(ProductId);
    }
    @Operation(summary = "更新Comment")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateComment(@RequestBody CommentVo commentVo) {
        return commentService.updateComment(commentVo);
    }

    @Operation(summary = "删除Comment by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteCommentById(@PathVariable Long id) {
        return commentService.deleteCommentById(id);
    }
    @Operation(summary = "点赞评论")
    @RequestMapping(value = "/like/{commentId}/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public Result likeComment(@PathVariable Long commentId, @PathVariable Long userId) {
        return commentService.likeComment(commentId, userId);
    }
    @Cacheable("comments")
    @Operation(summary = "获取评论的点赞用户")
    @RequestMapping(value = "/likedUsers/{commentId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getLikedUsers(@PathVariable Long commentId) {
        return commentService.getLikedUsers(commentId);
    }

}
