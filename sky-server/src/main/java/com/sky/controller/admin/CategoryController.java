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

import java.util.List;

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

    @PostMapping( "/status/{status}")
    @ApiOperation("修改分类状态")
    public Result startOrStop(@PathVariable Integer status, Long id){
        log.info("修改分类状态：{},{}",status,id);
        CategoryService.startOrStop(status,id);
        return Result.success();
    }
    @PostMapping
    @ApiOperation("新增菜品分类")
    public Result<Category> save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增菜品分类：{}",categoryDTO);
        CategoryService.save(categoryDTO);
        return Result.success();
    }
    @DeleteMapping
    @ApiOperation("删除菜品分类")
    public Result delete(@RequestParam Long id){
        log.info("删除菜品分类：{}",id);
        CategoryService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        log.info("根据类型查询分类：{}",type);
        List<Category> list = CategoryService.list(type);
        return Result.success(list);
    }
}

