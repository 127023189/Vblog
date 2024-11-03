package org.yixi.vblogserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yixi.vblogserver.bean.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> getAllCategories();

    /**
     * 新增分类
     * @param category
     * @return
     */
    int addNewCate(Category category);

    /**
     * 更新分类
     * @param category
     * @return
     */
    int updateCate(Category category);

    /**
     * 删除分类
     * @param ids
     * @return
     */
    int deleteById(@Param("ids") String[] ids);
}
