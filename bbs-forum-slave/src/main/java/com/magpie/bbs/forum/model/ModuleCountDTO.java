package com.magpie.bbs.forum.model;

/**
 * @Title: ModuleCountDTO
 * @Description: 模块统计对象模型
 * @Date: 2019/4/25 14:53
 * @Auther: zhaoxuezhao
 */
public class ModuleCountDTO {
    String name;
    Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
