package com.yuntu.service;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User login(String userCode,String userPassword);
    void getPage(PageUtil pageUtil);
    boolean addStu(User user);
    boolean delStu(@Param("id") int id);
    boolean updStu(User user);
    User selStu(@Param("id")int id);
}
