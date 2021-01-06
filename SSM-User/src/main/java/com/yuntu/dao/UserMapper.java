package com.yuntu.dao;

import com.yuntu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User login(@Param("userName") String userName,@Param("password") String password);
}
