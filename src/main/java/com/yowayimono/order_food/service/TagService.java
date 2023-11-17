package com.yowayimono.order_food.service;


import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.PageSelect;

public interface TagService {
     Result AddTag(String TagTitle);


     Result DelTag(String TagTitle);

     Result FindTag(PageSelect page);

     Result FindTagByName(String TagTitle);

     Result MatchTag(String Term) ;

}
