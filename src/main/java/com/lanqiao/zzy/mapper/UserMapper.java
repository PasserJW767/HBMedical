package com.lanqiao.zzy.mapper;


import com.lanqiao.zzy.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @Entity com.lanqiao.zzy.domain.User
*/
@Mapper
public interface UserMapper {

    public User selectForLogin(User user);

    int insertSelective(User record);

    //    根据用户名选择出具体的用户
    User selectByUsername(String username);

}
