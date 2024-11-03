package org.yixi.vblogserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yixi.vblogserver.bean.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 查找分页数据
     * @param state
     * @param start
     * @param count
     * @param keyword
     * @param uid
     * @return
     */
    List<Article> getArticleByState(@Param("state") Integer state,@Param("start") int start,@Param("count") Integer count,@Param("keyword") String keyword,@Param("uid") Long uid);

    /**
     * 查询当前id所拥有的文章个数
     * @param state
     * @param uid
     * @param keyword
     * @return
     */
    int getArticleCountByState(Integer state, Long uid, String keyword);

    /**
     * 更新文章状态,将其逻辑设为2
     * @param aids
     * @param state
     * @return
     */
    int updateArticleState(Long[] aids, Integer state);

    /**
     * 删除文章
     * @param aids
     * @return
     */
    int deleteArticleById(@Param("aids") Long[] aids);

    /**
     * 获取所有pv的时间
     * @param id
     * @return
     */
    List<String> getAllCategories(Long id);

    /**
     * 获取pv数据
     * @param id
     * @return
     */
    List<Integer> getDataStatistics(Long id);
}
