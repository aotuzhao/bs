package com.magpie.bbs.forum.common.feign.factory;

import com.magpie.bbs.forum.common.feign.fallback.UserFeignServiceFallbackImpl;
import com.magpie.bbs.forum.feign.FeignUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @Description: UserFeignServiceFallbackFactory
 * @date: 2019/4/16 21:34
 * @author：zhaoxuezhao
 */
@Component
public class UserFeignServiceFallbackFactory implements FallbackFactory<FeignUserService> {


    @Override
    public FeignUserService create(Throwable cause) {
        UserFeignServiceFallbackImpl userFeignServiceFallback = new UserFeignServiceFallbackImpl();
        userFeignServiceFallback.setCause(cause);
        return userFeignServiceFallback;
    }
}
