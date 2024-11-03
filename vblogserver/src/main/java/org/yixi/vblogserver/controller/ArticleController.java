package org.yixi.vblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yixi.vblogserver.bean.Article;
import org.yixi.vblogserver.bean.RespBean;
import org.yixi.vblogserver.service.ArticleService;
import org.yixi.vblogserver.utils.Util;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    //格式化时间
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/all")
    public Map<String, Object> getArticleByStateByAdmin(@RequestParam(value = "state",defaultValue = "-1") Integer state,@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "count",defaultValue = "6") Integer count, String keyword){
        //查找当前页的文章
        List<Article> articles = articleService.getArticleByState(state,page,count,keyword); //查找全部
        HashMap<String, Object> map = new HashMap<>();
        map.put("articles",articles);
        map.put("totalCount",articleService.getArticleCountByState(state, Util.getCurrentUser().getId(),keyword));
        return map;
    }

    @PutMapping("/dustbin")
    public RespBean updateArticleState(Long[] aids, Integer state){
         if(articleService.updateArticleState(aids,state) == aids.length){
             return new RespBean("success","删除成功");
         }
         return new RespBean("error","删除失败");
    }

    @RequestMapping("/dataStatistics")
    public Map<String,Object> getArticleDataStatistics(){
        Map<String,Object> map = new HashMap<>();
        List<String> categories = articleService.getCategories(); //拿到分类
        List<Integer> dataStatistics = articleService.getDataStatistics();
        map.put("categories",categories);
        map.put("ds",dataStatistics);
        return map;
    }

}
