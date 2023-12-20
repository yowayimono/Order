package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.DishTag;
import com.yowayimono.order_food.mapper.DishTagMapper;
import com.yowayimono.order_food.service.DishTagService;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DishTagServiceImpl implements DishTagService {

    @Autowired
    DishTagMapper dishTagMapper;
    @Override
    public Result AddTag(TagVo tag) {
        DishTag t = dishTagMapper.findByTitle(tag.getTitle());
        if(t != null){
            return Result.success(4444,"标签已存在！");
        }

        DishTag dishTag = new DishTag();
        dishTag.setTitle(tag.getTitle());
        dishTag.setDescription(tag.getDescription());
        dishTag.setCreatetime(LocalDateTime.now());




        if(dishTagMapper.insert(dishTag)>0){
            System.out.println("Insert successful!");
            return Result.success(666,"添加标签成功！", dishTag);
        } else {
            System.out.println("Insert failed!");
            return Result.fail(4444,"添加失败！");
        }


    }

    @Override
    public Result DelTag(String tagTitle) {
        DishTag dishTag = dishTagMapper.findByTitle(tagTitle);
        if (dishTag == null) {
            return Result.fail(4444, "标签不存在！");
        }

        if(dishTag.getDeletetime()!=null) {
            return Result.fail(4444,"标签不存在或已被删除！ ");
        }
        dishTag.setDeletetime(LocalDateTime.now());
        System.out.println(dishTag);
        dishTagMapper.update(dishTag);

        return Result.success(666, "删除标签成功！");
    }

    @Override
    public Result FindTagByPage(PageSelect page) {
        // log.warn("正在查找标签:", page.toString());
        Long offset = (page.getCurrent() - 1) * page.getPagesize();
        List<DishTag> result = dishTagMapper.findTags(page.getPagesize(), offset) ;

        return Result.success(result);
    }

    @Override
    public Result FindTagByName(String tagTitle) {
        DishTag dishTag = dishTagMapper.findByTitle(tagTitle);
        if (dishTag == null) {
            return Result.fail(4444, "标签不存在！");
        }
        return Result.success(dishTag);
    }

    @Override
    public Result MatchTag(String Term) {
        List<DishTag> result = dishTagMapper.findTagsByPartialMatch(Term);
        return Result.success(result);
    }

}

