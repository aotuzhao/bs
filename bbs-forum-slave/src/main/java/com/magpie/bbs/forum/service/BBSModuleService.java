package com.magpie.bbs.forum.service;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.model.BbsModule;

import java.util.List;

/**
 * @Title: BBSModuleService
 * @Description: 模块管理
 * @Date: 2019/4/25 10:33
 * @Auther: zhaoxuezhao
 */
public interface BBSModuleService {
    Integer addModule(BbsModule module);

    Integer updataModule(BbsModule module);


    JSONObject getBbsModuleList(BbsModule module);
    JSONObject getBbsModuleCount();

    List<BbsModule> getModuleList();
}
