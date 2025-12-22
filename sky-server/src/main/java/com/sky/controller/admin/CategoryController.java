package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 分类管理控制器
 * 处理分类相关的HTTP请求
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService CategoryService;


    /**
     * 修改菜品分类
     * @param category
     * @return
     */
    @PutMapping
    @ApiOperation("编辑菜品分类")
    public Result update(@RequestBody Category category){
        log.info("编辑菜品分类：{}",category);
        CategoryService.update(category);
        return Result.success();

    }
    @GetMapping("/page")
    @ApiOperation("分页查询所有菜品分类")
    public Result<PageResult> page(CategoryPageQueryDTO  categoryPageQueryDTO){
        log.info("分页查询所有菜品分类：{}",categoryPageQueryDTO);
        PageResult pageResult = CategoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }


}
