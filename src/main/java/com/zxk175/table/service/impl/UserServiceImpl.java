package com.zxk175.table.service.impl;

import com.zxk175.table.dao.UserMapper;
import com.zxk175.table.pojo.User;
import com.zxk175.table.pojo.UserExample;
import com.zxk175.table.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zxk175 on 16/11/13.
 */

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertSelective(user);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userDao.deleteByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> getAllUserByExample(UserExample example) {
        return userDao.selectByExample(example);
    }
}
