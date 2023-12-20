package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Product;
import com.yowayimono.order_food.mapper.ProductMapper;
import com.yowayimono.order_food.service.ProductService;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.ThingVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper ProductMapper;

    private ModelMapper modelMapper;

    public ProductServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertProduct(ThingVo ThingVo) {
        try {
            System.out.println(ThingVo.toString());
            Product Product = modelMapper.map(ThingVo, Product.class);
            Product.setCreateTime(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
            System.out.println(Product.toString());
            int result = ProductMapper.insertProduct(Product);
            if (result > 0) {
                return Result.success(666, "插入成功！", Product);
            } else {
                return Result.fail(44444, "插入失败！");
            }
        } catch (Exception e) {
            System.out.println(e);
            return Result.fail(4444, "插入失败！");
        }
    }
    @Override
    public Result countProducts() {
        try {
            int count = ProductMapper.countProduct();
            return Result.success(666, "查询成功！", count);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
    @Override
    public Result selectProductById(Long id) {
        try {
            Product Product = ProductMapper.selectById(id);
            if (Product != null) {
                return Result.success(666, "查询成功！", Product);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAllProducts() {
        try {
            List<Product> Products = ProductMapper.selectList(null);
            return Result.success(666, "查询成功！", Products);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateProduct(ThingVo ThingVo) {
        try {
            Product Product = modelMapper.map(ThingVo, Product.class);
            int result = ProductMapper.updateById(Product);
            if (result > 0) {
                return Result.success(666, "更新成功！", Product);
            } else {
                return Result.fail(4444, "更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "更新失败！");
        }
    }

    @Override
    public Result deleteProductById(Long id) {
        try {
            int result = ProductMapper.deleteById(id);
            if (result > 0) {
                return Result.success(666, "删除成功！", id);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }
    @Override
    public Result updateProductStatus(Long ProductId, String status) {
        try {
            Product Product = ProductMapper.selectById(ProductId);
            if (Product == null) {
                return Result.fail(4444, "商品不存在！");
            }

            // 更新商品状态
            Product.setStatus(status);
            int result = ProductMapper.updateById(Product);

            if (result > 0) {
                return Result.success(666, "商品状态更新成功！", Product);
            } else {
                return Result.fail(4444, "商品状态更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "商品状态更新失败！");
        }
    }
    @Override
    public Result selectProductsWithPagination(PageSelect page) {
        try {
            //Page<Product> page = new Page<>(current, size);
            Long offset = (page.getCurrent() - 1) * page.getPagesize();
            List<Product> result = ProductMapper.getByPage(page.getPagesize(), offset);

            return Result.success(666, "查询成功！", result);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
}
