package com.yuntu.dao;

import com.yuntu.pojo.UserInfo;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface UserInfoMapper {
    List<UserInfo> getPageAll(PageUtil<UserInfo> pageUtil);
    int count();
}
