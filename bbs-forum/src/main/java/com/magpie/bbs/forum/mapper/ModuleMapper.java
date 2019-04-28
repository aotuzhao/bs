package com.magpie.bbs.forum.mapper;

import com.magpie.bbs.forum.model.BbsModule;
import com.magpie.bbs.forum.model.ModuleCountDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title: ModuleMapper
 * @Description: TODO
 * @Date: 2019/4/25 10:56
 * @Auther: zhaoxuezhao
 */
@Mapper
public interface ModuleMapper {
    List<BbsModule> getModuleList(BbsModule module);


    int countModule();

    BbsModule getModule(Integer id);

    void updateModule(BbsModule module);
    void addModule(BbsModule module);

    List<ModuleCountDTO> getModuleCount();
    List<BbsModule> getAllModule();
}
