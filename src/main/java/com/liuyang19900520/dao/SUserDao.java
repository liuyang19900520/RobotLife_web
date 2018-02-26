package com.liuyang19900520.dao;

import com.liuyang19900520.domain.SUser;

public interface SUserDao {

    SUser findAllInfoByUserName(String userName);

    SUser findByUserName(String userName);

    int insertUser(SUser user);

}
