package org.blumea.cms.web.controller;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.ArticleEntity;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.ArticleService;
import org.blumea.cms.web.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 文章控制器
 * User: shijingui
 * Date: 2016/1/16
 */
@Controller
@RequestMapping("/adm/article")
public class ArticleControler extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ArticleControler.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listArticle() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article/list_article");
        PageData pd = this.getPageData();
        String title = pd.getString("title");
        int page = pd.getInt("page");
        int categoryId = pd.getInt("categoryId");
        try {
            ServiceResponse<Pagination<ArticleEntity>> serviceResponse = articleService.getArticleListWithPage(title, categoryId, page, 15);
            modelAndView.addObject("page", serviceResponse.getResponseData());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addAritcle() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article/add_article");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveArticle(ArticleEntity article) {
        ModelAndView modelAndView = new ModelAndView();
        PageData pageData = this.getPageData();

        try {
            article.setCreateTime(new Date(System.currentTimeMillis()));
            articleService.addArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("article/add_article");
        return modelAndView;
    }


}
