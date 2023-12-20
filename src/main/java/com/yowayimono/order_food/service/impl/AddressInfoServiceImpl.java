package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.AddressInfo;
import com.yowayimono.order_food.mapper.AddressInfoMapper;
import com.yowayimono.order_food.service.AddressInfoService;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.AddressVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressInfoServiceImpl implements AddressInfoService {

    @Autowired
    private AddressInfoMapper addressMapper;



    private ModelMapper modelMapper;

    public AddressInfoServiceImpl() {
        modelMapper = new ModelMapper();
    }


    @Override
    public Result insertAddress(AddressVo addressVo) {
        try {
            AddressInfo ad = modelMapper.map(addressVo, AddressInfo.class);
            int result = addressMapper.insertAddress(ad);
            if (result > 0) {
                return Result.success(666, "插入成功！", addressVo);
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
            AddressInfo address = addressMapper.selectAddressById(id);
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
            List<AddressInfo> addresses = addressMapper.selectAllAddressesByUserId(id);
            return Result.success(666, "查询成功！", addresses);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateAddress(AddressVo addressVo) {
        try {
            AddressInfo ad = modelMapper.map(addressVo, AddressInfo.class);
            int result = addressMapper.updateAddress(ad);
            if (result > 0) {
                return Result.success(666, "更新成功！", addressVo);
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
    public Result selectAddressesWithPagination(PageSelect page) {
        Long offset = (page.getCurrent()- 1) * page.getPagesize();
        try {
            List<AddressInfo> addresses = addressMapper.selectAddressesWithPagination(page.getPagesize(),offset);
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
        return null;
    }

    @Override
    public Result selectAddressesPage(PageSelect page, Long userId) {
        try {
            Long offset = (page.getCurrent()-1) * page.getPagesize();
            List<AddressInfo> result = addressMapper.selectPageUser(page.getPagesize(),offset, userId);
            return Result.success(666, "查询成功！", result);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

}