package com.yuntu.dao;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> getPage(PageUtil pageUtil);
    int getCount();
    int addStu(Student student);
    int delStu(@Param("id") int id);
    int updStu(Student student);
    Student selStu(@Param("id")int id);
}
