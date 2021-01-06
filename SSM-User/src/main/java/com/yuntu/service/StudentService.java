package com.yuntu.service;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    void getPage(PageUtil pageUtil);
    boolean addStu(Student student);
    boolean delStu(int id);
    boolean updStu(Student student);
    Student selStu(int id);
}
