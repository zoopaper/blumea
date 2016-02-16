package org.blumea.cms.web.controller;

import net.common.utils.json.JsonWrite;
import org.apache.commons.codec.digest.DigestUtils;
import org.blumea.cms.entity.UserEntity;
import org.blumea.cms.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 注册
 * User: shijingui
 * Date: 2016/2/15
 */
@Controller
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(UserEntity userEntity) {
        JsonWrite jsonWrite = new JsonWrite();
        try {
            userEntity.setCreateTime(new Date());
            userEntity.setPassword(DigestUtils.md5Hex(userEntity.getPassword()));
            userService.addUser(userEntity);
            jsonWrite.setSuccess(true);
        } catch (Exception e) {
            jsonWrite.setData(false);
            e.printStackTrace();
        }
        return jsonWrite;
    }

    /**
     * 判断是否已存在用户
     *
     * @return
     */
    @RequestMapping(value = "/isExistUser", method = RequestMethod.POST)
    @ResponseBody
    public Object isExistUser() {
        JsonWrite jsonWrite = new JsonWrite();

        return jsonWrite;
    }

    /**
     * 判断是否已存在邮箱
     *
     * @return
     */
    @RequestMapping(value = "/isExistEmail", method = RequestMethod.POST)
    @ResponseBody
    public Object isExistEmail() {
        JsonWrite jsonWrite = new JsonWrite();

        return jsonWrite;
    }
}
