package org.blumea.cms.web.controller;

import org.blumea.cms.entity.CategoryEntity;
import org.blumea.cms.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * User: shijingui
 * Date: 2016/1/21
 */
@Controller
@RequestMapping("/adm/category/")
public class CategoryController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category/category");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addCategory(CategoryEntity categoryEntity) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            categoryService.addCategory(categoryEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


}
