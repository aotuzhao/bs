package com.magpie.bbs.forum.service;

import com.alibaba.fastjson.JSONObject;
import com.magpie.bbs.forum.model.BbsUser;


public interface BbsUserService {


    //积分规则
    int BBS_TOPIC_SCORE = 10;
    int BBS_POST_SCORE = 3;
    int BBS_REPLAY_SCORE = 3;


    //level 用户等级
    int REFRESH_THRESHOLD = 30;
    int OLD_THRESHOLD = 100;
    int TEACHER_THRESHOLD = 200;
    int DIRECTOR_THRESHOLD = 350;
    int PRESIDENT_THRESHOLD = 700;


    void addTopicScore(long userId);

    void addPostScore(long userId);

    void addReplayScore(long userId);

    BbsUser setUserAccount(BbsUser user);

    BbsUser getUserAccount(String userName, String password);

    boolean hasUser(String userName);

    BbsUser getUserAccount(String userName);

    BbsUser getUser(Integer id);


    Boolean editUser(BbsUser user);

    JSONObject getUserList(BbsUser user);

    int updateUser(BbsUser user);

}
