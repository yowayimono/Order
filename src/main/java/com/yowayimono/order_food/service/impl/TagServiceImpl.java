package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Tag;
import com.yowayimono.order_food.mapper.TagMapper;
import com.yowayimono.order_food.service.TagService;
import com.yowayimono.order_food.vo.PageSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;
    @Override
    public Result AddTag(String TagTitle) {
        Tag tag = new Tag();
        tag.setCreatetime(Timestamp.valueOf(LocalDateTime.now()));

        if(tagMapper.insert(tag)>0){
            return Result.success(666,"添加标签成功！");
        }
        return Result.fail(4444,"添加失败！");
    }

    @Override
    public Result DelTag(String tagTitle) {
        Tag tag = tagMapper.findByTitle(tagTitle);
        if (tag == null) {
            return Result.fail(4444, "标签不存在！");
        }

        tagMapper.deleteByTitle(tagTitle);

        return Result.success(666, "删除标签成功！");
    }

    @Override
    public Result FindTag(PageSelect page) {
        List<String> result = tagMapper.findTags(page.getPagesize(),page.getOffect()) ;

        return Result.success(result);
    }

    @Override
    public Result FindTagByName(String tagTitle) {
        Tag tag = tagMapper.findByTitle(tagTitle);
        if (tag == null) {
            return Result.fail(4444, "标签不存在！");
        }
        return Result.success(tag);
    }

    @Override
    public Result MatchTag(String Term) {
        List<Tag> result = tagMapper.findTagsByPartialMatch(Term);
        return Result.success(result);
    }

}

