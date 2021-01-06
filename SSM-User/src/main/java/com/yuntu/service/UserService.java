package com.yuntu.service;

import com.yuntu.pojo.User;

public interface UserService {
    User login(String userName, String password);
}
