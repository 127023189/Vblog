package org.yixi.vblogserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yixi.vblogserver.bean.Article;
import org.yixi.vblogserver.mapper.ArticleMapper;
import org.yixi.vblogserver.utils.Util;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getArticleByState(Integer state,Integer page,Integer count,String keyword){
        int start = (page-1)*count;
        Long uid = Util.getCurrentUser().getId();
        return articleMapper.getArticleByState(state,start,count,keyword,uid);
    }

    public int getArticleCountByState(Integer state,Long uid,String keyword){
        return articleMapper.getArticleCountByState(state,uid,keyword);
    }

    public int updateArticleState(Long[] aids, Integer state) {
        // 删除
        if(state == 2){
            return articleMapper.deleteArticleById(aids);
        }else{
            return articleMapper.updateArticleState(aids,state);
        }
    }

    public List<String> getCategories() {
        return articleMapper.getAllCategories(Util.getCurrentUser().getId());
    }

    public List<Integer> getDataStatistics() {
        return articleMapper.getDataStatistics(Util.getCurrentUser().getId());
    }
}
