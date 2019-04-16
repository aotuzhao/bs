package com.magpie.bbs.user.mapper;

import com.magpie.bbs.user.model.BbsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @date 2019/4/4 14:15
 * @description: 用户信息管理
 */
@Mapper
public interface UserMapper {


    List<BbsUser> getUserList(BbsUser user);

    int countUser(BbsUser user);


    int updateUser(BbsUser user);
}
