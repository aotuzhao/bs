package com.magpie.bbs.forum.model;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 *
 * @Description: 版块对象模型
 * @date: 2019/4/16 17:35
 * @author：zhaoxuezhao
 */
public class BbsModule  extends BasePage{
	@Excel(name = "主键", orderNum = "1", mergeVertical = true)
	private Integer id ;
	@Excel(name = "优先级", orderNum = "4", mergeVertical = true)
	private Integer turn ;
	@Excel(name = "详情", orderNum = "3", width=30,mergeVertical = true)
	private String detail ;
	@Excel(name = "名称", orderNum = "2", mergeVertical = true)
	private String name ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
