package com.magpie.bbs.forum.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.common.WebUtils;
import com.magpie.bbs.forum.model.BbsModule;
import com.magpie.bbs.forum.model.BbsTopic;
import com.magpie.bbs.forum.model.BbsUser;
import com.magpie.bbs.forum.service.BBSModuleService;
import com.magpie.bbs.forum.service.BBSService;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Title: ModuleController
 * @Description: 模块管理
 * @Date: 2019/4/25 10:22
 * @Auther: zhaoxuezhao
 */
@Controller
public class ModuleController {

    @Autowired
    WebUtils webUtils;

    @Autowired
    BBSService bbsService;

    @Autowired
    BBSModuleService moduleService;

    @RequestMapping("/bbs/myModule.html")
    public ModelAndView myModule(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        view.setViewName("/moduleManage.html");
        BbsUser user = webUtils.currentUser(request, response);
        if (null == user) {
            try {
                response.sendRedirect("/bbs/bbs/index/1.html");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return view;
        }
        List<BbsTopic> list = bbsService.getMyTopics(user.getId());
        view.addObject("list", list);
        return view;
    }

    @RequestMapping("/bbs/getModuleList")
    @ResponseBody
    public JSONObject toModule(BbsModule module) {
        if (module == null || null == module.getCurrentPage() || null == module.getPageSize()) {
            module = new BbsModule();
            module.setCurrentPage(1);
            module.setPageSize(10);
        }
        JSONObject list = moduleService.getBbsModuleList(module);
        return list;
    }

    @RequestMapping("/bbs/updateModule")
    @ResponseBody
    public Integer updateModule(BbsModule module) {
        Integer integer = moduleService.updataModule(module);
        return integer;
    }

    @RequestMapping("/bbs/addModule")
    @ResponseBody
    public JSONObject addModule(BbsModule module) {
        JSONObject result = new JSONObject();
        Integer integer = moduleService.addModule(module);
        if (integer == 1) {
            result.put("err", 0);
            result.put("msg", "/bbs/myModule.html");
        }else {
            result.put("err", 1);
            result.put("err","添加失败！请稍后重试！");
        }
        return result;
    }

    @RequestMapping("/bbs/getModuleCount")
    @ResponseBody
    public JSONObject getModuleCount() {
        return moduleService.getBbsModuleCount();
    }

    @RequestMapping("/bbs/downloadModule")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("模块信息".getBytes("utf-8"), "ISO-8859-1") + ".xls");
        //编码
        response.setCharacterEncoding("ISO-8859-8");
        List<BbsModule> moduleList = moduleService.getModuleList();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), BbsModule.class, moduleList);
        workbook.write(response.getOutputStream());
    }

}
