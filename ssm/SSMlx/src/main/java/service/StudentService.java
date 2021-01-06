package service;

import pojo.PageUtil;
import pojo.Student;

import java.util.List;

public interface StudentService {
    //分页
    void getPage(PageUtil pageUtil);

    //增加
    int addStu(Student student);

    //删除
    int delStu(int id);

    //修改
    int updStu(Student student);

    //查询单个
    Student getStuById(int id);
}
