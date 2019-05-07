package com.magpie.bbs.forum.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.mapper.ModuleMapper;
import com.magpie.bbs.forum.model.BbsModule;
import com.magpie.bbs.forum.model.ModuleCountDTO;
import com.magpie.bbs.forum.service.BBSModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: BBSModuleServiceImpl
 * @Description: 版块管理
 * @Date: 2019/4/25 10:45
 * @Auther: zhaoxuezhao
 */
@Service
public class BBSModuleServiceImpl implements BBSModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addModule(BbsModule module) {
        try {
            moduleMapper.addModule(module);
            return 1;
        } catch (Exception e) {
            return -1;

        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updataModule(BbsModule module) {
        BbsModule module1 = moduleMapper.getModule(module.getId());
        module1.setTurn(-1 == module.getTurn() ? module1.getTurn() + 1 : module1.getTurn() - 1);
        if (module1.getTurn() <= 0) {
            module1.setTurn(1);
        }
        moduleMapper.updateModule(module1);
        return 1;
    }

    @Override
    public JSONObject getBbsModuleList(BbsModule module) {
        if (null != module.getPageSize() && null != module.getCurrentPage()) {
            module.setCurrentPage((module.getCurrentPage() - 1) * module.getPageSize());
            module.setPageSize(module.getPageSize());
        }
        List<BbsModule> moduleList = moduleMapper.getModuleList(module);
        JSONObject jsonObject = new JSONObject();
        int count = moduleMapper.countModule();
        int pageNum = count % module.getPageSize() == 0 ? count / module.getPageSize() : count / module.getPageSize() + 1;
        jsonObject.put("pageNum", pageNum);
        jsonObject.put("current", module.getCurrentPage() + 1);
        jsonObject.put("data", moduleList);
        return jsonObject;
    }

    @Override
    public JSONObject getBbsModuleCount() {
        JSONObject jsonObject = new JSONObject();
        List<ModuleCountDTO> dtoList = moduleMapper.getModuleCount();
        List<String> names = dtoList.stream().map(ModuleCountDTO::getName).collect(Collectors.toList());
        jsonObject.put("names", names);
        jsonObject.put("datas", dtoList);
        return jsonObject;
    }

    @Override
    public List<BbsModule> getModuleList() {
        return moduleMapper.getAllModule();
    }
}
