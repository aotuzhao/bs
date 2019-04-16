package com.magpie.bbs.forum.model;
import org.beetl.sql.core.TailBean;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 *
 * @Description: 用户对象模型
 * @date: 2019/4/16 16:30
 * @author：zhaoxuezhao
 */
public class BbsUser extends TailBean {

	private Integer id ;
	@Excel(name = "等级", orderNum = "5", mergeVertical = true, isImportField = "level")
	private Integer level ;
	@Excel(name = "积分", orderNum = "4", mergeVertical = true, isImportField = "score")
	private Integer score ;
	@Excel(name = "积分余额", orderNum = "6", mergeVertical = true, isImportField = "balance")
	private Integer balance;
	private String password;
	@Excel(name = "邮箱", orderNum = "3", mergeVertical = true, isImportField = "email")
	private String email ;
	@Excel(name = "用户名", orderNum = "1", mergeVertical = true, isImportField = "userName")
	private String userName ;
	@Excel(name = "公司", orderNum = "7", mergeVertical = true, isImportField = "corp")
	private String corp;
	private Integer sex;
	private Integer status;
	private Integer currentPage;
	private Integer pageSize;
	@Excel(name = "性别", orderNum = "2", mergeVertical = true, isImportField = "sexName")
	private String sexName;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getCorp() {
		return corp;
	}
	public void setCorp(String corp) {
		this.corp = corp;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return sex;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getSexName() {
		return sexName;
	}


}
