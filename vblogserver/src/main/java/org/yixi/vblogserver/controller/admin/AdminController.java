package org.yixi.vblogserver.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yixi.vblogserver.bean.Article;
import org.yixi.vblogserver.bean.RespBean;
import org.yixi.vblogserver.service.ArticleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/article/all")
    public Map<String, Object> getArticleByStateByAdmin(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "count",defaultValue = "6") Integer count, String keyword){
        //查找当前页的文章
        List<Article> articles = articleService.getArticleByState(-2,page,count,keyword); //查找全部
        HashMap<String, Object> map = new HashMap<>();
        map.put("articles",articles);
        map.put("totalCount",articleService.getArticleCountByState(1,null,keyword));
        return map;
    }

    @PutMapping("/article/dustbin")
    public RespBean updateArticleState(Long[] aids,Integer state){
        if (articleService.updateArticleState(aids, state) == aids.length) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }
}
