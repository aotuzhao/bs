package com.magpie.bbs.forum.es.annotation;

import java.lang.annotation.*;

/**
 *
 * @Description: 创建索引的注解
 * @date: 2019/4/16 21:24
 * @author：zhaoxuezhao
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EsIndexType {
	
	EsEntityType entityType();					//实体类型
	EsOperateType operateType();			//操作类型
	String key() default "id";					//获取主键的名称
	
}
