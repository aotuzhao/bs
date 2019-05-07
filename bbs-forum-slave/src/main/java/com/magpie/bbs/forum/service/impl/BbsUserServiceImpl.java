package com.magpie.bbs.forum.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.dao.BbsUserDao;
import com.magpie.bbs.forum.mapper.UserMapper;
import com.magpie.bbs.forum.model.BbsUser;
import com.magpie.bbs.forum.service.BbsUserService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class BbsUserServiceImpl implements BbsUserService {

	
	
	@Autowired
	BbsUserDao userDao;
	

	@Autowired
	SQLManager sqlManager;

	@Autowired
	UserMapper userMapper;

	
	
	/**
	 * 分5个级别
	 * @param score
	 * @return
	 */
	private int getLevel(int score){
		if(score>=BbsUserService.PRESIDENT_THRESHOLD){
			return 5;
		}else if(score>=BbsUserService.DIRECTOR_THRESHOLD){
			return 4;
		}else if(score>=BbsUserService.TEACHER_THRESHOLD){
			return 3;
		}if(score>=BbsUserService.OLD_THRESHOLD){
			return 2;
		}else{
			return 1 ;
		}
	}




	@Override
	public BbsUser setUserAccount(BbsUser user){
		user.setStatus(0);
		userDao.insert(user,true);
		return user;
		
	}

	@Override
	public BbsUser getUserAccount(String userName, String password) {
		BbsUser query = new BbsUser();
		query.setUserName(userName);
		query.setPassword(password);
		List<BbsUser> list = userDao.template(query);
		if(list.size()==0){
			return null;
		}
		BbsUser user = list.get(0);
		return user;
	}


	@Override
	public void addTopicScore(long userId) {
		addScore(userId,BbsUserService.BBS_TOPIC_SCORE);
		
	}

	@Override
	public void addPostScore(long userId) {
		addScore(userId,BbsUserService.BBS_POST_SCORE);
		
	}

	@Override
	public void addReplayScore(long userId) {
		addScore(userId,BbsUserService.BBS_REPLAY_SCORE);
		
	}
	
	private void addScore(long userId,int total){
		BbsUser user = userDao.unique(userId);
		Integer scoreInt =  user.getScore();
		if (null == scoreInt) {
			scoreInt = 0;
		}
		int score = scoreInt+total;
		Integer balanceInt = user.getBalance();
		if (null == balanceInt) {
			balanceInt = 0;
		}
		int balance = balanceInt+total;
		user.setScore(score);
		user.setBalance(balance);
		user.setLevel(getLevel(score));
		userDao.updateById(user);
	}




	@Override
	public boolean hasUser(String userName) {
		BbsUser user = new BbsUser();
		user.setUserName(userName);
		List list = userDao.template(user);
		return !list.isEmpty();
	}

	@Override
	public BbsUser getUserAccount(String userName) {
		BbsUser query = new BbsUser();
		query.setUserName(userName);
		List<BbsUser> list = userDao.template(query);
		if(CollectionUtils.isEmpty(list)){
			return new BbsUser();
		}
		return list.get(0);
	}


	@Override
	public BbsUser getUser(Integer id) {
		return sqlManager.unique(BbsUser.class, id);
	}

	@Override
	public Boolean editUser(BbsUser user) {

		user.setStatus(0);
		int result = userDao.updateById(user);

		if (result > 0) {
			return true;
		}
		return false;
	}


	@Override
	public JSONObject getUserList(BbsUser user) {

		if (null != user.getCurrentPage() && user.getPageSize() != null) {
			user.setCurrentPage((user.getCurrentPage() - 1) * user.getPageSize());
			user.setPageSize(user.getPageSize());
		}

		List<BbsUser> userList = userMapper.getUserList(user);
		JSONObject jsonObject = new JSONObject();
		int count =  userMapper.countUser(user);
		int pageNum = count%user.getPageSize()==0?count/user.getPageSize():count/user.getPageSize()+1;
		jsonObject.put("pageNum", pageNum);
		jsonObject.put("current", user.getCurrentPage() +1);
		jsonObject.put("data", userList);
		user.setSex(1);
		jsonObject.put("male", userMapper.countUser(user));
		user.setSex(0);
		jsonObject.put("female", userMapper.countUser(user));

		return jsonObject;
	}

	@Override
	public int updateUser(BbsUser user) {

		// 状态 (0 正常, 1冻结, -1 删除)
		if (user.getStatus() == 0) {
			user.setStatus(1);
		} else {
			user.setStatus(0);
		}
		return userMapper.updateUser(user);
	}

}
