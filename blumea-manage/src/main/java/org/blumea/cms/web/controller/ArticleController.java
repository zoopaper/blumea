package org.blumea.cms.web.controller;

import org.blumea.cms.auth.Principal;
import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.ArticleEntity;
import org.blumea.cms.entity.CategoryEntity;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.ArticleService;
import org.blumea.cms.service.CategoryService;
import org.blumea.cms.utils.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 文章管理
 * User: shijingui
 * Date: 2016/1/16
 */
@Controller
@RequestMapping("/adm/article")
public class ArticleController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listArticle(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Principal principal = this.getPrincipal();
        if (principal == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.setViewName("article/list_article");
        PageData pd = this.getPageData();
        int page = ServletRequestUtils.getIntParameter(request, "page", 1);
        int categoryId = ServletRequestUtils.getIntParameter(request, "categoryId", -1);
        String title = ServletRequestUtils.getStringParameter(request, "title", "");


        pd.put("userId", principal.getUserId());
        pd.put("page", page);
        pd.put("categoryId", categoryId);
        pd.put("pageSize", 10);
        pd.put("title", title);

        try {

            ServiceResponse<Pagination<ArticleEntity>> serviceResponse = articleService.getArticleListWithPage(pd);
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

        List<CategoryEntity> categoryEntityList = categoryService.getAllCategory();
        modelAndView.addObject("categoryList", categoryEntityList);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveArticle(ArticleEntity article) {
        ModelAndView modelAndView = new ModelAndView();
        Principal principal = this.getPrincipal();
        if (principal == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        PageData pageData = this.getPageData();
        try {
            article.setUserId(principal.getUserId());
            article.setCreateTime(new Date(System.currentTimeMillis()));
            articleService.addArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("redirect:/adm/article/add");
        return modelAndView;
    }
}
