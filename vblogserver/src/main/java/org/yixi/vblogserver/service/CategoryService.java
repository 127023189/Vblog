package org.yixi.vblogserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yixi.vblogserver.bean.Category;
import org.yixi.vblogserver.mapper.CategoryMapper;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    public  List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    public int addNewCate(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        return categoryMapper.addNewCate(category);
    }

    public int updateCate(Category category) {
        return categoryMapper.updateCate(category);
    }

    public int deleteById(String ids) {
        String[] split =ids.split(",");
        return categoryMapper.deleteById(split);
    }
}
