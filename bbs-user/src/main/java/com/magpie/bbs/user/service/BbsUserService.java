package com.magpie.bbs.user.service;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.user.model.BbsUser;

/**
 *
 * @Description: 用户信息管理
 * @date: 2019/4/16 21:28
 * @author：zhaoxuezhao
 */
public interface  BbsUserService {

	/**
	 *
	 * @Title: getUserList
	 * @Description: 获取用户信息列表
	 * @date: 2019/4/16 21:29
	 * @author：zhaoxuezhao
	 */
	JSONObject getUserList(BbsUser user);
	/**
	 *
	 * @Title: updateUser
	 * @Description: 更新用户信息
	 * @date: 2019/4/16 21:29
	 * @author：zhaoxuezhao
	 */
	int updateUser(BbsUser user);

}
