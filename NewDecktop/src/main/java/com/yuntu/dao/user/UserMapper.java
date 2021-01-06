package com.yuntu.dao.user;

import com.yuntu.pojo.User;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface UserMapper {
    User Login(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
    int updPwd(@Param("pwd") String newPwd, @Param("id") int id);
    List<User> getUserPage(PageUtil<User> pageUtil);
    User getUserById(int id);
    int getCount();
    int addUser(User user);
    int updUser(User user);
    int delUser(int id);
    List<User> getUserByCondition(@Param("userName") String userName,@Param("userRole") int userRole);
}