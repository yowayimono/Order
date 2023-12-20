package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Comment;
import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.mapper.CommentMapper;
import com.yowayimono.order_food.mapper.UserMapper;
import com.yowayimono.order_food.service.CommentService;
import com.yowayimono.order_food.vo.CommentVo;
import com.yowayimono.order_food.vo.UserInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    private ModelMapper modelMapper;

    public CommentServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertComment(CommentVo commentVo) {
        try {
            Comment comment = modelMapper.map(commentVo, Comment.class);
            comment.setCreateTime(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
            int result = commentMapper.insert(comment);
            if (result > 0) {
                return Result.success(666, "插入成功！", comment);
            } else {
                return Result.fail(4444, "插入失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "插入失败！");
        }
    }

    @Override
    public Result selectCommentById(Long id) {
        try {
            Comment comment = commentMapper.selectById(id);
            if (comment != null) {
                return Result.success(666, "查询成功！", comment);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAllComments() {
        try {
            List<Comment> comments = commentMapper.selectList(null);
            return Result.success(666, "查询成功！", comments);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectCommentsByProductId(Long ProductId) {
        try {
            QueryWrapper<Comment> wrapper = new QueryWrapper<>();
            wrapper.eq("ProductId", ProductId);
            List<Comment> comments = commentMapper.selectList(wrapper);
            return Result.success(666, "查询成功！", comments);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateComment(CommentVo commentVo) {
        try {
            Comment comment = modelMapper.map(commentVo, Comment.class);
            int result = commentMapper.updateById(comment);
            if (result > 0) {
                return Result.success(666, "更新成功！", comment);
            } else {
                return Result.fail(4444, "更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "更新失败！");
        }
    }

    @Override
    public Result deleteCommentById(Long id) {
        try {
            int result = commentMapper.deleteById(id);
            if (result > 0) {
                return Result.success(666, "删除成功！", id);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }

    @Override
    public Result countCommentsByProductId(Long ProductId) {
        try {
            QueryWrapper<Comment> wrapper = new QueryWrapper<>();
            wrapper.eq("ProductId", ProductId);
            Long count = commentMapper.selectCount(wrapper);
            return Result.success(666, "查询成功！", count);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result likeComment(Long commentId, Long userId) {
        try {
            Comment comment = commentMapper.selectById(commentId);
            if (comment == null) {
                return Result.fail(4444, "评论不存在！");
            }

            // Check if the user already liked the comment
            String likedUserIds = comment.getLikedUserIds();
            if (likedUserIds != null && Arrays.asList(likedUserIds.split(",")).contains(String.valueOf(userId))) {
                return Result.fail(4444, "用户已经点过赞！");
            }

            // Update the liked user IDs
            if (likedUserIds == null || likedUserIds.isEmpty()) {
                likedUserIds = String.valueOf(userId);
            } else {
                likedUserIds += "," + userId;
            }

            // Update the comment's like count and liked user IDs
            comment.setLikeCount(comment.getLikeCount() + 1);
            comment.setLikedUserIds(likedUserIds);
            commentMapper.updateById(comment);

            return Result.success(666, "点赞成功！");
        } catch (Exception e) {
            return Result.fail(4444, "点赞失败！");
        }
    }

    @Override
    public Result getLikedUsers(Long commentId) {
        try {
            Comment comment = commentMapper.selectById(commentId);
            if (comment == null) {
                return Result.fail(4444, "评论不存在！");
            }

            // Retrieve and return the liked user IDs
            String likedUserIds = comment.getLikedUserIds();
            List<Long> likedUsers = new ArrayList<>();
            if (likedUserIds != null && !likedUserIds.isEmpty()) {
                likedUsers = Arrays.stream(likedUserIds.split(","))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
            }

            // List<User> userlist = userMapper.findUsers(page.getPagesize(), page.getOffect());

            List<UserInfo> result = new ArrayList<>();
            for (Long id : likedUsers) {
                User user = userMapper.selectById(id);
                UserInfo userInfo = modelMapper.map(user, UserInfo.class);
                result.add(userInfo);
            }


            return Result.success(666, "查询成功！", result);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
}
