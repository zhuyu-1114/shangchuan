package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;
import util.PageUtil;

import java.util.List;

public interface UserMapper {
    //登录
    User login(@Param("userName") String userName,@Param("passWord") String passWord);

    //分页
    List<User> getPage(PageUtil pageUtil);
    int getCount();

    //根据性别和name查询（条件查询）
    List<User> getUserBySexAndName(@Param("sex") String sex,@Param("name") String name);

    int addUser(User user);
    int delUser(int id);
    int updUser(User user);
    User getUserById(int id);

}
