package com.ctr.epidemic.service.impl;

import com.ctr.epidemic.mapper.UserMapper;
import com.ctr.epidemic.model.UserInfo;
import com.ctr.epidemic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/2/26 12:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserInfo findByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }
}
