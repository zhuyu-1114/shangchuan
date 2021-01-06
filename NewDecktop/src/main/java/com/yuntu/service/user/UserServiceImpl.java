package com.yuntu.service.user;

import com.yuntu.dao.user.UserMapper;
import com.yuntu.pojo.Bill;
import com.yuntu.pojo.User;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User Login(String userCode, String userPassword) {
        return userMapper.Login(userCode,userPassword);
    }

    @Override
    public boolean updPwd(String newPwd,int id) {
        if (userMapper.updPwd(newPwd,id)>0){
            return true;
        }
        return false;
    }

    @Override
    public void getUserPage(PageUtil<User> pageUtil) {
        int count = userMapper.getCount();
        pageUtil.setCounts(count);
        if (pageUtil.getPagecount()>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(userMapper.getUserPage(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList<User>());
        }
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        if (userMapper.addUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updUser(User user) {
        if (userMapper.updUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delUser(int id) {
        if (userMapper.delUser(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUserByCondition(String userName, int userRole) {
        return userMapper.getUserByCondition(userName,userRole);
    }
}
