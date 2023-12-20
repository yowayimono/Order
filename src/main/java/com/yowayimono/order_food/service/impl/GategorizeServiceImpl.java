package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Categorize;
import com.yowayimono.order_food.mapper.GategorizeMapper;
import com.yowayimono.order_food.service.GategorizeService;
import com.yowayimono.order_food.vo.PageSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GategorizeServiceImpl implements GategorizeService {



    @Autowired
    private GategorizeMapper classificationMapper;



    @Override
    public Result getClassificationById(Long id) {
        try {
            Categorize categorize = classificationMapper.selectClassificationById(id);
            return Result.success(666, "查询成功！", categorize);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result getClassificationByTitle(String title) {
        try {
            Categorize categorize = classificationMapper.selectClassificationByTitle(title);
            return Result.success(666, "查询成功！", categorize);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result getAllClassifications() {
        try {
            List<Categorize> categorizes = classificationMapper.selectAllClassifications();
            return Result.success(666, "查询成功！", categorizes);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateClassification(String oldTitle,  String newTitle) {
        try {
            Categorize categorize = classificationMapper.selectClassificationByTitle(oldTitle);

            if (categorize == null) {
                return Result.fail(4444, "分类不存在！");
            }

            // Update the title
            categorize.setTitle(newTitle);

            // Update the classification
            classificationMapper.updateClassification(categorize);

            return Result.success(666, "更新成功！");
        } catch (Exception e) {
            return Result.fail(4444, "更新失败！");
        }
    }


    @Override
    public Result deleteClassificationById(Long id) {
        try {
            classificationMapper.deleteClassificationById(id);
            return Result.success(666, "删除成功！");
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }

    @Override
    public Result getClassificationsWithPagination(PageSelect page) {
        try {
            Long offset = (page.getCurrent() - 1) * page.getPagesize();
            List<Categorize> categorizes = classificationMapper.selectClassificationsWithPagination(page.getPagesize(),offset);
            return Result.success(666, "查询成功！", categorizes);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result countClassifications() {
        try {
            int count = classificationMapper.countClassifications();
            return Result.success(666, "查询成功！", count);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }


        @Override
        public Result addClassification(String title) {
            Categorize categorize = new Categorize();
            categorize.setTitle(title);
            categorize.setCreateTime(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());

            if (classificationMapper.insert(categorize) > 0) {
                return Result.success(666, "添加分类成功！");
            }
            return Result.fail(4444, "添加失败！");
        }


        @Override
        public Result deleteClassificationByTitle(String title) {
            Categorize categorize = classificationMapper.selectClassificationByTitle(title);
            if (categorize == null) {
                return Result.fail(4444, "分类不存在！");
            }

            classificationMapper.deleteClassificationByTitle(title);

            return Result.success(666, "删除分类成功！");
        }
}
