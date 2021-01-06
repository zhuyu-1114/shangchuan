package service;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import util.PageUtil;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
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
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void getPage(PageUtil pageUtil) {
        int count = userMapper.getCount();
        pageUtil.setCounts(count);
        if(count>0){
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<User> list = userMapper.getPage(pageUtil);
            pageUtil.setLists(list);
        }else{
            pageUtil.setLists(new ArrayList<User>());
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> getUserBySexAndName(String sex, String name) {
        return userMapper.getUserBySexAndName(sex,name);
    }

    @Override
    public boolean addUser(User user) {
        if(userMapper.addUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delUser(int id) {
        if(userMapper.delUser(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updUser(User user) {
        if(userMapper.updUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
