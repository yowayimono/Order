package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.DishTag;
import com.yowayimono.order_food.enitiy.Product;
import com.yowayimono.order_food.enitiy.ProductAndDishTag;
import com.yowayimono.order_food.mapper.DishTagMapper;
import com.yowayimono.order_food.mapper.ProductMapper;
import com.yowayimono.order_food.mapper.ProductTagMapper;
import com.yowayimono.order_food.service.ProductTagService;
import com.yowayimono.order_food.vo.ProductTagVo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTagServiceImpl implements ProductTagService {

    @Autowired
    private ProductTagMapper ProductTagMapper;

    @Autowired
    DishTagMapper dishTagMapper;

    @Autowired
    ProductMapper ProductMapper;
    private ModelMapper modelMapper;

    public ProductTagServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Result insertProductTag(ProductTagVo ProductTagVo) {
        try {
            ProductAndDishTag productAndDishTag = modelMapper.map(ProductTagVo, ProductAndDishTag.class);
            int result = ProductTagMapper.insert(productAndDishTag);
            if (result > 0) {
                return Result.success(666, "插入成功！", productAndDishTag);
            } else {
                return Result.fail(4444, "插入失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "插入失败！");
        }
    }


    @Override
    public Result selectProductsByTagId(Long tagId) {
        try {
            QueryWrapper<ProductAndDishTag> wrapper = new QueryWrapper<>();
            wrapper.eq("tagId", tagId);
            List<ProductAndDishTag> productAndDishTags = ProductTagMapper.selectList(wrapper);

            List<Product> Products = new ArrayList<>();
            for (ProductAndDishTag productAndDishTag : productAndDishTags) {
                Product Product = ProductMapper.selectById(productAndDishTag.getProductId());
                Products.add(Product);
            }

            return Result.success(666, "查询成功！", Products);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectTagsByProductId(Long ProductId) {
        try {
            QueryWrapper<ProductAndDishTag> wrapper = new QueryWrapper<>();
            wrapper.eq("ProductId", ProductId);
            List<ProductAndDishTag> productAndDishTags = ProductTagMapper.selectList(wrapper);

            List<DishTag> dishTags = new ArrayList<>();
            for (ProductAndDishTag productAndDishTag : productAndDishTags) {
                DishTag dishTag = dishTagMapper.selectById(productAndDishTag.getTagId());
                dishTags.add(dishTag);
            }

            return Result.success(666, "查询成功！", dishTags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectProductTagById(Long id) {
        try {
            ProductAndDishTag productAndDishTag = ProductTagMapper.selectById(id);
            if (productAndDishTag != null) {
                return Result.success(666, "查询成功！", productAndDishTag);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAllProductTags() {
        try {
            List<ProductAndDishTag> productAndDishTags = ProductTagMapper.selectList(null);
            return Result.success(666, "查询成功！", productAndDishTags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectProductTagsByProductId(Long ProductId) {
        try {
            QueryWrapper<ProductAndDishTag> wrapper = new QueryWrapper<>();
            wrapper.eq("ProductId", ProductId);
            List<ProductAndDishTag> productAndDishTags = ProductTagMapper.selectList(wrapper);
            return Result.success(666, "查询成功！", productAndDishTags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectProductTagsByTagId(Long tagId) {
        try {
            QueryWrapper<ProductAndDishTag> wrapper = new QueryWrapper<>();
            wrapper.eq("tagId", tagId);
            List<ProductAndDishTag> productAndDishTags = ProductTagMapper.selectList(wrapper);
            return Result.success(666, "查询成功！", productAndDishTags);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result updateProductTag(ProductTagVo ProductTagVo) {
        try {
            ProductAndDishTag productAndDishTag = modelMapper.map(ProductTagVo, ProductAndDishTag.class);
            int result = ProductTagMapper.updateById(productAndDishTag);
            if (result > 0) {
                return Result.success(666, "更新成功！", productAndDishTag);
            } else {
                return Result.fail(4444, "更新失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "更新失败！");
        }
    }

    @Override
    public Result deleteProductTagById(Long id) {
        try {
            int result = ProductTagMapper.deleteById(id);
            if (result > 0) {
                return Result.success(666, "删除成功！", id);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }
}
