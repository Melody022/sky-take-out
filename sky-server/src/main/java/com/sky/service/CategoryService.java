package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;


public interface CategoryService {
    void update(Category category);

    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}
