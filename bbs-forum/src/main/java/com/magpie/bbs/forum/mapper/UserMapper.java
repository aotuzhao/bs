package com.magpie.bbs.forum.mapper;

import com.magpie.bbs.forum.model.BbsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @date 2019/4/4 14:15
 * @description:
 */
@Mapper
public interface UserMapper {


    List<BbsUser> getUserList(BbsUser user);

    int countUser(BbsUser user);


    int updateUser(BbsUser user);
}
