package com.magpie.bbs.forum.feign;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.model.BbsUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.magpie.bbs.forum.common.feign.factory.*;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author pierce
 * @date 2019/4/10 14:14
 * @description:
 */
@FeignClient(name="user", path = "/bbs", fallbackFactory = UserFeignServiceFallbackFactory.class)
public interface FeignUserService {

    @RequestMapping(value = "/bbs/user/list")
    JSONObject getUserList(@RequestBody BbsUser user);

    @RequestMapping("/bbs/user/update")
    Integer updateUser(@RequestBody BbsUser user);
}
