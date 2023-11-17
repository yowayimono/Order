package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Classification;
import com.yowayimono.order_food.mapper.ClassificationMapper;
import com.yowayimono.order_food.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {



    @Autowired
    private ClassificationMapper classificationMapper;



    @Override
    public Result getClassificationById(Long id) {
        try {
            Classification classification = classificationMapper.selectClassificationById(id);
            return Result.success(666, "查询成功！", classification);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result getClassificationByTitle(String title) {
        try {
            Classification classification = classificationMapper.selectClassificationByTitle(title);
            return Result.success(666, "查询成功！", classification);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result getAllClassifications() {
        try {
            List<Classification> classifications = classificationMapper.selectAllClassifications();
            return Result.success(666, "查询成功！", classifications);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateClassification(String oldTitle, String newTitle) {
        try {
            Classification classification = classificationMapper.selectClassificationByTitle(oldTitle);

            if (classification == null) {
                return Result.fail(4444, "分类不存在！");
            }

            // Update the title
            classification.setTitle(newTitle);

            // Update the classification
            classificationMapper.updateClassification(classification);

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
    public Result getClassificationsWithPagination(Long page, Long pageSize) {
        try {
            Long offset = (page - 1) * pageSize;
            List<Classification> classifications = classificationMapper.selectClassificationsWithPagination(offset, pageSize);
            return Result.success(666, "查询成功！", classifications);
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

        // Method to add a new classification
        @Override
        public Result addClassification(String title) {
            Classification classification = new Classification();
            classification.setTitle(title);
            classification.setCreateTime(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());

            if (classificationMapper.insert(classification) > 0) {
                return Result.success(666, "添加分类成功！");
            }
            return Result.fail(4444, "添加失败！");
        }

        // Method to delete a classification by title
        @Override
        public Result deleteClassificationByTitle(String title) {
            Classification classification = classificationMapper.selectClassificationByTitle(title);
            if (classification == null) {
                return Result.fail(4444, "分类不存在！");
            }

            classificationMapper.deleteClassificationByTitle(title);

            return Result.success(666, "删除分类成功！");
        }
}
