package com.lanqiao.zzy.service;


import com.lanqiao.zzy.domain.User;

/**
*
*/
public interface IUserService {
    public User selectForLogin(User user);

    int insertSelective(User record);

    //    根据用户名选择出具体的用户
    User selectByUsername(String username);

}
