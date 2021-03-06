package com.magpie.bbs.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.user.mapper.UserMapper;
import com.magpie.bbs.user.model.BbsUser;
import com.magpie.bbs.user.service.BbsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Description: 用户信息管理
 * @date: 2019/4/16 21:27
 * @author：zhaoxuezhao
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BbsUserService bbsUserService;


    @RequestMapping("/bbs/user/list")
    @ResponseBody
    public JSONObject getUserList(@RequestBody BbsUser user) {

        return bbsUserService.getUserList(user);
    }

    @RequestMapping("/bbs/user/update")
    public Integer updateUser(@RequestBody BbsUser user) {

        return bbsUserService.updateUser(user);
    }

}
