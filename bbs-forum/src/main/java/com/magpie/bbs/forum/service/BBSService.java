package com.magpie.bbs.forum.service;

import com.magpie.bbs.forum.model.*;
import org.beetl.sql.core.engine.PageQuery;

import java.util.Date;
import java.util.List;

public interface BBSService {
	BbsTopic getTopic(Integer topicId);
	BbsPost getPost(int postId);
	BbsReply getReply(int replyId);
	
	PageQuery getTopics(PageQuery query);
	
	List<BbsTopic> getMyTopics(int userId);
	
	Integer getMyTopicsCount(int userId);
	
	public void updateMyTopic(int msgId, int status);

	public BbsMessage makeOneBbsMessage(int userId, int topicId, int statu);


	public void notifyParticipant(int topicId, int ownerId);
	
	PageQuery getHotTopics(PageQuery query);

	PageQuery getNiceTopics(PageQuery query);

	PageQuery getPosts(PageQuery query);

	void saveUser(BbsUser user);

	BbsUser login(BbsUser user);

	void saveTopic(BbsTopic topic, BbsPost post, BbsUser user);
	

	void savePost(BbsPost post, BbsUser user);


	void saveReply(BbsReply reply);

	void deleteTopic(int id);

	void deletePost(int id);
	
	void deleteReplay(int id);
	
	void updateTopic(BbsTopic topic);
	void updatePost(BbsPost post);
	
	Date getLatestPost(int userId);
	
	BbsPost getFirstPost(Integer topicId);
	
}
