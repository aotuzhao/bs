package com.magpie.bbs.forum.es.vo;

import com.magpie.bbs.forum.es.annotation.EsEntityType;
import com.magpie.bbs.forum.es.annotation.EsOperateType;

/**
 *
 * @Description: EsIndexType注解的数据
 * @date: 2019/4/16 21:18
 * @author：zhaoxuezhao
 */
public class EsIndexTypeData {

	/**
	 * 实体类型
	 */
	private EsEntityType entityType;
	/**
	 * 操作类型
	 */
	private EsOperateType operateType;
	/**
	 * 获取主键
	 */
	private Object id;
	
	public EsEntityType getEntityType() {
		return entityType;
	}
	public void setEntityType(EsEntityType entityType) {
		this.entityType = entityType;
	}
	public EsOperateType getOperateType() {
		return operateType;
	}
	public void setOperateType(EsOperateType operateType) {
		this.operateType = operateType;
	}
	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id;
	}
	public EsIndexTypeData(EsEntityType entityType, EsOperateType operateType, Object id) {
		super();
		this.entityType = entityType;
		this.operateType = operateType;
		this.id = id;
	}
	public EsIndexTypeData() {
		super();
	}
	
	
	
	
	
}
