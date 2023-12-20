package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.AddressVo;

public interface AddressInfoService {


    Result insertAddress(AddressVo addressVo);

    Result selectAddressById(Long id);

    Result selectAllAddressesByUserId(Long id);

    Result updateAddress(AddressVo addressVo);

    Result deleteAddressById(Long id);



    Result countAddressesByUserId(Long id);

    Result selectAddressesPage(Long current, Long size, Long userId);

    Result selectAddressesWithPagination(PageSelect page);

    Result selectAddressesPage(PageSelect page, Long userId);

}