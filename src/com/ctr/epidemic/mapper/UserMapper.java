package com.ctr.epidemic.mapper;

import com.ctr.epidemic.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/20 18:03
 */
@Mapper
public interface UserMapper {

    @Select("select user_id, account, password, user_name " +
            "from users " +
            "where account=#{account} " +
            "and del_flag is null or del_flag=0;")
    UserInfo findUserByAccount(String account);
}
