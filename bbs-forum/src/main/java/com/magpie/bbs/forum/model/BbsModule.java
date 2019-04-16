package com.magpie.bbs.forum.model;

/**
 *
 * @Description: 版块对象模型
 * @date: 2019/4/16 17:35
 * @author：zhaoxuezhao
 */
public class BbsModule  {
	private Integer id ;
	private Integer turn ;
	private String detail ;
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
