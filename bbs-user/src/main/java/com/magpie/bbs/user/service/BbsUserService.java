package com.magpie.bbs.user.service;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.user.model.BbsUser;


public interface  BbsUserService {

	JSONObject getUserList(BbsUser user);

	int updateUser(BbsUser user);

}
