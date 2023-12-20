package com.yowayimono.order_food.service;


import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.TagVo;

public interface DishTagService {
     Result AddTag(TagVo tag);


     Result DelTag(String TagTitle);

     Result FindTagByPage(PageSelect page);

     Result FindTagByName(String TagTitle);

     Result MatchTag(String Term) ;

}
