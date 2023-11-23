package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Tag;
import com.yowayimono.order_food.mapper.TagMapper;
import com.yowayimono.order_food.service.TagService;
import com.yowayimono.order_food.vo.PageSelect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;
    @Override
    public Result AddTag(String TagTitle) {
        Tag t = tagMapper.findByTitle(TagTitle);
        if(t != null){
            return Result.success(4444,"标签已存在！");
        }

        Tag tag = new Tag();
        tag.setTitle(TagTitle);
        tag.setCreatetime(Timestamp.valueOf(LocalDateTime.now()));
        log.info("Tag title before insertion: {}", tag.getTitle());


        System.out.println("Before insert: " + tag.getTitle());
        if(tagMapper.insert(tag)>0){
            System.out.println("Insert successful!");
            return Result.success(666,"添加标签成功！",tag);
        } else {
            System.out.println("Insert failed!");
            return Result.fail(4444,"添加失败！");
        }


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
        log.warn("正在查找标签:", page.toString());
        List<Tag> result = tagMapper.findTags(page.getPagesize(),page.getOffect()) ;

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

