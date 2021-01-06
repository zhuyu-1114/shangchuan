package service;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserService {

    //登录
    User login(@Param("userName") String userName, @Param("password") String password);
}
