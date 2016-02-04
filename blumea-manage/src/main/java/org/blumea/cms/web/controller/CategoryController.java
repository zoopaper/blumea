package org.blumea.cms.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.common.utils.json.JsonWrite;
import org.blumea.cms.auth.Principal;
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
import java.util.Date;
import java.util.List;

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
    public JsonWrite addCategory(CategoryEntity categoryEntity) {
        JsonWrite jsonWrite = new JsonWrite();
        try {
            Principal principal = this.getLoginPrincipal(this.getRequest());
            categoryEntity.setCreateTime(new Date());
            categoryEntity.setArticleNum(0);
//            categoryEntity.setUserId(principal.getUserId());
            long id = categoryService.addCategory(categoryEntity);
            jsonWrite.setSuccess(true);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("categoryName", categoryEntity.getCategoryName());
            jsonObject.put("categoryId", categoryEntity.getId());
            jsonWrite.setData(jsonObject);
        } catch (Exception e) {
            jsonWrite.setSuccess(false);
            e.printStackTrace();
        }
        return jsonWrite;
    }

    @RequestMapping(value = "/getAllCategory", method = RequestMethod.POST)
    @ResponseBody
    public JsonWrite getAllCategory() {
        JsonWrite jsonWrite = new JsonWrite();
        try {
            List<CategoryEntity> categoryEntityList = categoryService.getAllCategory();
            jsonWrite.setSuccess(true);
            JSONArray jsonArray = new JSONArray();
            if (categoryEntityList != null) {
                for (CategoryEntity categoryEntity : categoryEntityList) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("categoryName", categoryEntity.getCategoryName());
                    jsonObject.put("categoryId", categoryEntity.getId());
                    jsonObject.put("categoryNum", categoryEntity.getArticleNum());
                    jsonArray.add(jsonObject);
                }
            }
            jsonWrite.setData(jsonArray);
        } catch (Exception e) {
            jsonWrite.setSuccess(false);
            e.printStackTrace();
        }
        return jsonWrite;
    }


    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    @ResponseBody
    public JsonWrite deleteCategory(CategoryEntity categoryEntity) {
        JsonWrite jsonWrite = new JsonWrite();
        try {
            categoryService.deleteCategory(categoryEntity);
            jsonWrite.setSuccess(true);
        } catch (Exception e) {
            jsonWrite.setSuccess(false);
            e.printStackTrace();
        }
        return jsonWrite;
    }
}
