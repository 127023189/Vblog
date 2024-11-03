package org.yixi.vblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yixi.vblogserver.bean.Category;
import org.yixi.vblogserver.bean.RespBean;
import org.yixi.vblogserver.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/all")
    public List<Category> getAllCategories(){
        return  categoryService.getAllCategories();
    }

    @PostMapping("/")
    public RespBean addNewCate(Category category){
        if("".equals(category.getCateName()) || category.getCateName()==null){
            return new RespBean("error","分类名不能为空");
        }
        if(categoryService.addNewCate(category) == 1){
            return new RespBean("success","添加成功");
        }
        return new RespBean("error","添加失败");
    }

    @PutMapping("/")
    public RespBean updateCate(Category category){
        if(categoryService.updateCate(category) == 1){
            return new RespBean("success","修改成功");
        }
        return new RespBean("error","修改失败");
    }

    @DeleteMapping("/{ids}")
    public RespBean deleteById(@PathVariable String ids){
        int result = categoryService.deleteById(ids);
        if (result==1){
            return new RespBean("success","删除成功");
        }
        return new RespBean("error","删除失败");

    }
}
