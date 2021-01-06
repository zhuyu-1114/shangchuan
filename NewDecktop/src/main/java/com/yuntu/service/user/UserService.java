package com.yuntu.service.user;

import com.yuntu.pojo.User;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User Login( String userCode,  String userPassword);
    boolean updPwd(String newPwd,int id);
    void getUserPage(PageUtil<User> pageUtil);
    User getUserById(int id);
    boolean addUser(User user);
    boolean updUser(User user);
    boolean delUser(int id);
    List<User> getUserByCondition(String userName,int userRole);
}
