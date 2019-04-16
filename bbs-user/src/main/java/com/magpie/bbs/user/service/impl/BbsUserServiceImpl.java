package com.magpie.bbs.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.user.mapper.UserMapper;
import com.magpie.bbs.user.model.BbsUser;
import com.magpie.bbs.user.service.BbsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BbsUserServiceImpl implements BbsUserService {

	
	
	@Autowired
    UserMapper userMapper;

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
