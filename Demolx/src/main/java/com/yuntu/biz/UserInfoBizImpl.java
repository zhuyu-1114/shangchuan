package com.yuntu.biz;

import com.yuntu.dao.UserInfoMapper;
import com.yuntu.pojo.UserInfo;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service("UserInfoBiz")
public class UserInfoBizImpl implements UserInfoBiz{
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfoBizImpl() {
    }

    public UserInfoBizImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfoMapper getUserInfoMapper() {
        return userInfoMapper;
    }
    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }
    public void getPageAll(PageUtil<UserInfo> pageUtil) {
        int count = userInfoMapper.count();
        if (count>0){
            pageUtil.setCounts(count);
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(userInfoMapper.getPageAll(pageUtil));
        } else{
            pageUtil.setLists(new ArrayList<UserInfo>());
        }
    }
}
