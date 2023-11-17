package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Classification;

import java.util.List;

public interface ClassificationService {

    // Method to get a classification by ID
    Result getClassificationById(Long id);

    Result getClassificationByTitle(String name);
    // Method to get all classifications
    Result getAllClassifications();

    // Method to update an existing classification
    Result updateClassification(String oldtitle, String newtitle);

    // Method to delete a classification by ID
    Result deleteClassificationById(Long id);



    Result getClassificationsWithPagination(Long page, Long pageSize);

    // Method to get the total number of classifications
    Result countClassifications();

    // Method to add a new classification
    Result addClassification(String title);

    // Method to delete a classification by title
    Result deleteClassificationByTitle(String title);
}
