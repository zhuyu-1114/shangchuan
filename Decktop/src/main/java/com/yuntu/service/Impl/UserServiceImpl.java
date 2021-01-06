package com.yuntu.service.Impl;

import com.yuntu.dao.UserMapper;
import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.User;
import com.yuntu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String userCode, String userPassword) {
        return userMapper.login(userCode, userPassword);
    }

    @Override
    public void getPage(PageUtil pageUtil) {
        int count = userMapper.getCount();
        if(count>0){
            pageUtil.setCounts(count);
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<User> list = userMapper.getPage(pageUtil);
            pageUtil.setLists(list);
        }else{
            List<User> list = new ArrayList<User>();
        }
    }

    @Override
    public boolean addStu(User user) {
        if (userMapper.addStu(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delStu(int id) {
        if (userMapper.delStu(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updStu(User user) {
        if (userMapper.updStu(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public User selStu(int id) {
        return userMapper.selStu(id);
    }
}
