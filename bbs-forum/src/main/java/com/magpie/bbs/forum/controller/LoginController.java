package com.magpie.bbs.forum.controller;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.common.WebUtils;
import com.magpie.bbs.forum.model.BbsUser;
import com.magpie.bbs.forum.service.BbsUserService;
import com.magpie.bbs.forum.util.HashKit;
import com.magpie.bbs.forum.util.VerifyCodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LoginController {


    @Autowired
    SQLManager sql;

    @Autowired
    BbsUserService bbsUserService;

    static final String CODE_NAME = "verCode";


    /**
     * 登录方法改为ajax方式登录
     *
     * @param userName
     * @param password
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/bbs/user/login")
    public JSONObject login(String userName, String password, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("err", 1);
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            result.put("msg", "请输入正确的内容！");
        } else {
            password = HashKit.md5(password);
            BbsUser user = bbsUserService.getUserAccount(userName, password);
            if (user == null) {
                result.put("msg", "用户不存在或密码错误");
            } else {
                if (user.getStatus() == 1) {
                    result.put("msg", "该账户已冻结, 无法登陆!");
                } else {
                    WebUtils.loginUser(request, response, user, true);
                    result.put("msg", "/bbs/index/1.html");
                    result.put("err", 0);
                }
            }
        }
        return result;
    }

    @GetMapping("/bbs/user/register.html")
    public ModelAndView loginPage(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/register.html");
        return view;
    }

    /**
     * 登出方法改为ajax方式登出
     *
     * @param request
     * @param response
     */
    @ResponseBody
    @PostMapping("/bbs/user/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        WebUtils.logoutUser(request, response);
    }

    /**
     * 注册改为 ajax 方式注册
     *
     * @param user
     * @param code
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @PostMapping("/bbs/user/doRegister")
    public JSONObject register(BbsUser user, String code, HttpServletRequest request, HttpServletResponse response) {

        if (null != user.getId()) {
            return this.edit(user, code, request, response);
        }

        JSONObject result = new JSONObject();
        result.put("err", 1);
        HttpSession session = request.getSession(true);
        String verCode = (String) session.getAttribute(CODE_NAME);
        if (!verCode.equalsIgnoreCase(code)) {
            result.put("msg", "验证码输入错误");
        } else if (bbsUserService.hasUser(user.getUserName())) {
            result.put("msg", "用户已经存在");
        } else {
            String password = HashKit.md5(user.getPassword());
            user.setPassword(password);
            user.setBalance(10);
            user.setLevel(1);
            user.setScore(10);
            user = bbsUserService.setUserAccount(user);
            WebUtils.loginUser(request, response, user, true);
            result.put("err", 0);
            result.put("msg", "/bbs/index");
        }
        return result;
    }


    /**
     * 修改个人资料
     *
     * @param user
     * @param code
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @PostMapping("/bbs/user/edit")
    public JSONObject edit(BbsUser user, String code, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("err", 1);
        HttpSession session = request.getSession(true);
        String verCode = (String) session.getAttribute(CODE_NAME);
        if (!verCode.equalsIgnoreCase(code)) {
            result.put("msg", "验证码输入错误");
        } else {

            BbsUser bbsUser = bbsUserService.getUser(user.getId());
            if (null == bbsUser) {
                result.put("msg", "用户不存在!");
                return result;
            }

            bbsUser.setEmail(user.getEmail());
            bbsUser.setCorp(user.getCorp());
            if (bbsUserService.editUser(user)) {
                result.put("err", 0);
                result.put("msg", "/bbs/index");
            } else {
                result.put("msg", "修改失败!");
            }

        }
        return result;
    }


    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/bbs/user/detail")
    public JSONObject detail(Integer id) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("err", 1);

        if (null == id) {
            jsonObject.put("msg", "Id不能为空!");
            return jsonObject;
        }

        BbsUser user = bbsUserService.getUser(id);

        if (null == user) {
            jsonObject.put("msg", "用户不存在!");
            return jsonObject;
        }

        user.setPassword("");
        jsonObject.put("err", 0);
        jsonObject.put("msg", user);

        return jsonObject;
    }

    @RequestMapping("/bbs/user/authImage")
    public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session 
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute(CODE_NAME);
        session.setAttribute(CODE_NAME, verifyCode.toLowerCase());
        //生成图片 
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

    }


}
