package com.ctr.epidemic.service;

import com.ctr.epidemic.model.UserInfo;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/2/26 12:05
 */
public interface UserService {

    UserInfo findByAccount(String account);
}
