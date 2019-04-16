package com.magpie.bbs.forum.model;
/**
 *
 * @Description: 消息对象模型
 * @date: 2019/4/16 17:35
 * @author：zhaoxuezhao
 */
public class BbsMessage  {
	private Integer id ;
	private Integer status ;
	private Integer topicId ;
	private Integer userId ;
	
	public BbsMessage() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public Integer getStatus(){
		return  status;
	}
	public void setStatus(Integer status ){
		this.status = status;
	}
	
	public Integer getTopicId(){
		return  topicId;
	}
	public void setTopicId(Integer topicId ){
		this.topicId = topicId;
	}
	
	public Integer getUserId(){
		return  userId;
	}
	public void setUserId(Integer userId ){
		this.userId = userId;
	}
	
	
	

}
