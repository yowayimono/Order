package com.yowayimono.order_food.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Address;
import com.yowayimono.order_food.vo.UserAndAddress;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AddressService {


    Result insertAddress(UserAndAddress userAndAddress);

    Result selectAddressById(Long id);

    Result selectAllAddressesByUserId(Long id);

    Result updateAddress(UserAndAddress userAndAddress);

    Result deleteAddressById(Long id);

    Result selectAddressesWithPagination(Long offset, Long limit);

    Result countAddressesByUserId(Long id);

    Result selectAddressesPage(Long current, Long size, Long userId);


    // Additional business logic methods can be added here
}