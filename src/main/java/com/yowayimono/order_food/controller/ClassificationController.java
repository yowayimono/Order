package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ClassificationService;
import com.yowayimono.order_food.vo.PageSelect;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@Tag(name = "分类管理")
@RequestMapping("/admin/classOp")
@RestController
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @ResponseBody
    @Operation(summary = "添加分类")
    @RequestMapping(value = "/addClassification", method = RequestMethod.POST)
    public Result addClassification(@Param("title") String title) {
        return classificationService.addClassification(title);
    }

    @ResponseBody
    @Operation(summary = "删除分类")
    @RequestMapping(value = "/deleteClassificationByTitle", method = RequestMethod.POST)
    public Result deleteClassificationByTitle(@Param("title") String title) {
        return classificationService.deleteClassificationByTitle(title);
    }

    @ResponseBody
    @Operation(summary = "获取分类详情")
    @RequestMapping(value = "/getClassificationById/{id}", method = RequestMethod.GET)
    public Result getClassificationById(@PathVariable Long id) {
        return classificationService.getClassificationById(id);
    }

    @ResponseBody
    @Operation(summary = "根据标题获取分类")
    @RequestMapping(value = "/getClassificationByTitle", method = RequestMethod.GET)
    public Result getClassificationByTitle(@RequestParam("title") String title) {
        return classificationService.getClassificationByTitle(title);
    }

    @ResponseBody
    @Operation(summary = "获取所有分类")
    @RequestMapping(value = "/getAllClassifications", method = RequestMethod.GET)
    public Result getAllClassifications() {
        return classificationService.getAllClassifications();
    }

    @ResponseBody
    @Operation(summary = "更新分类标题")
    @RequestMapping(value = "/updateClassification", method = RequestMethod.PUT)
    public Result updateClassification(@Param("oldTitle") String oldTitle, @Param("newTitle") String newTitle) {
        return classificationService.updateClassification(oldTitle, newTitle);
    }

    @ResponseBody
    @Operation(summary = "删除分类")
    @RequestMapping(value = "/deleteClassificationById/{id}", method = RequestMethod.DELETE)
    public Result deleteClassificationById(@PathVariable Long id) {
        return classificationService.deleteClassificationById(id);
    }

    @ResponseBody
    @Operation(summary = "分页查询分类")
    @RequestMapping(value = "/getClassificationsWithPagination", method = RequestMethod.GET)
    public Result getClassificationsWithPagination(@RequestBody PageSelect page) {
        return classificationService.getClassificationsWithPagination(page.getPagesize(), page.getOffect());
    }

    @ResponseBody
    @Operation(summary = "统计分类总数")
    @RequestMapping(value = "/countClassifications", method = RequestMethod.GET)
    public Result countClassifications() {
        return classificationService.countClassifications();
    }
}
