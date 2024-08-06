package com.lanqiao.zzy.service.impl;


import com.lanqiao.zzy.domain.User;
import com.lanqiao.zzy.mapper.UserMapper;
import com.lanqiao.zzy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
*
*/
@Service("userService")
//支持事务，增加、删除、更新操作单独使用propagation = Propagation.SUPPORTS
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectForLogin(User user){
        return userMapper.selectForLogin(user);
    };

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
