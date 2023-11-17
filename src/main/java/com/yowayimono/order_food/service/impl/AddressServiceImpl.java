package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Address;
import com.yowayimono.order_food.mapper.AddressMapper;
import com.yowayimono.order_food.service.AddressService;
import com.yowayimono.order_food.vo.UserAndAddress;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;



    private ModelMapper modelMapper;

    public AddressServiceImpl() {
        modelMapper = new ModelMapper();
    }


    @Override
    public Result insertAddress(UserAndAddress userAndAddress) {
        try {
            Address ad = modelMapper.map(userAndAddress,Address.class);
            int result = addressMapper.insertAddress(ad);
            if (result > 0) {
                return Result.success(666, "插入成功！", userAndAddress);
            } else {
                return Result.fail(4444, "插入失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "插入失败！");
        }
    }

    @Override
    public Result selectAddressById(Long id) {
        try {
            Address address = addressMapper.selectAddressById(id);
            if (address != null) {
                return Result.success(666, "查询成功！", address);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAllAddressesByUserId(Long id) {
        try {
            List<Address> addresses = addressMapper.selectAllAddressesByUserId(id);
            return Result.success(666, "查询成功！", addresses);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateAddress(UserAndAddress userAndAddress) {
        try {
            Address ad = modelMapper.map(userAndAddress,Address.class);
            int result = addressMapper.updateAddress(ad);
            if (result > 0) {
                return Result.success(666, "更新成功！", userAndAddress);
            } else {
                return Result.fail(4444, "更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "更新失败！");
        }
    }

    @Override
    public Result deleteAddressById(Long id) {
        try {
            int result = addressMapper.deleteAddressById(id);
            if (result > 0) {
                return Result.success(666, "删除成功！");
            } else {
                return Result.fail(4444, "未找到要删除的记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }

    @Override
    public Result selectAddressesWithPagination(Long offset, Long limit) {
        try {
            List<Address> addresses = addressMapper.selectAddressesWithPagination(offset, limit);
            return Result.success(666, "查询成功！", addresses);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result countAddressesByUserId(Long id) {
        try {
            int count = addressMapper.countAddressesByUserId(id);
            return Result.success(666, "查询成功！", count);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAddressesPage(Long current, Long size, Long userId) {
        try {
            Page<Address> page = new Page<>(current, size);
            IPage<Address> result = addressMapper.selectAddressesPage(page, userId);
            return Result.success(666, "查询成功！", result);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

}