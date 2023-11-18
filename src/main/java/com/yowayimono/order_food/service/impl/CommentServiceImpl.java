package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Comment;
import com.yowayimono.order_food.mapper.CommentMapper;
import com.yowayimono.order_food.service.CommentService;
import com.yowayimono.order_food.vo.CommentVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    private ModelMapper modelMapper;

    public CommentServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertComment(CommentVo commentVo) {
        try {
            Comment comment = modelMapper.map(commentVo, Comment.class);
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
    public Result selectCommentsByThingId(Long thingId) {
        try {
            QueryWrapper<Comment> wrapper = new QueryWrapper<>();
            wrapper.eq("thingId", thingId);
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
    public Result countCommentsByThingId(Long thingId) {
        try {
            QueryWrapper<Comment> wrapper = new QueryWrapper<>();
            wrapper.eq("thingId", thingId);
            Long count = commentMapper.selectCount(wrapper);
            return Result.success(666, "查询成功！", count);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

}
