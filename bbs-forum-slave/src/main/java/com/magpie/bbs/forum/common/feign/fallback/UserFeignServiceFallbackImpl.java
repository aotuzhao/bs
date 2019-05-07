package com.magpie.bbs.forum.common.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.feign.FeignUserService;
import com.magpie.bbs.forum.model.BbsUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @Description: feign熔断降级
 * @date: 2019/4/16 21:32
 * @author：zhaoxuezhao
 */
@Component
public class UserFeignServiceFallbackImpl implements FeignUserService {



    private Logger logger = LoggerFactory.getLogger(UserFeignServiceFallbackImpl.class);

    private Throwable cause;

    @Override
    public JSONObject getUserList(BbsUser user) {
        logger.error("System exception, service degradation, param:{}, cause:{}", JSONObject.toJSONString(user), cause);
        return null;
    }

    @Override
    public Integer updateUser(BbsUser user) {
        logger.error("System exception, service degradation, param:{}, cause:{}", JSONObject.toJSONString(user), cause);
        return null;
    }


    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
