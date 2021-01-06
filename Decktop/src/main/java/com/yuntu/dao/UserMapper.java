package com.yuntu.dao;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User login(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
    List<User> getPage(PageUtil pageUtil);
    int getCount();
    int addStu(User user);
    int delStu(@Param("id") int id);
    int updStu(User user);
    User selStu(@Param("id")int id);
}
