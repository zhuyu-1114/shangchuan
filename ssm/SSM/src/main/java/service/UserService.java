package service;

import org.apache.ibatis.annotations.Param;
import pojo.User;
import util.PageUtil;

import java.util.List;

public interface UserService {
    //登录
    User login(String userName, String passWord);

    //分页
    void getPage(PageUtil pageUtil);

    //根据性别和name查询（条件查询）
    List<User> getUserBySexAndName(String sex,String name);

    boolean addUser(User user);
    boolean delUser(int id);
    boolean updUser(User user);
    User getUserById(int id);
}
