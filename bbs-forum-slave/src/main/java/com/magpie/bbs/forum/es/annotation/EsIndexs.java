package com.magpie.bbs.forum.es.annotation;

import java.lang.annotation.*;
/**
 *
 * @Description: 创建索引的注解
 * @date: 2019/4/16 21:23
 * @author：zhaoxuezhao
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EsIndexs {
	
	EsIndexType[] value() default {};
	
}
