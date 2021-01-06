package com.yuntu.biz.impl;

import com.yuntu.biz.UserBiz;
import com.yuntu.dao.UserMapper;
import com.yuntu.entity.User;
import com.yuntu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserBizImpl implements UserBiz {
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
