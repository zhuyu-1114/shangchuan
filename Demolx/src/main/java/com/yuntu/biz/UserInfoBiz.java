package com.yuntu.biz;

import com.yuntu.pojo.UserInfo;
import com.yuntu.util.PageUtil;


public interface UserInfoBiz {
    void getPageAll(PageUtil<UserInfo> pageUtil);
}
