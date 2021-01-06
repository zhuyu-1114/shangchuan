package com.yuntu.dao;

import com.yuntu.pojo.Teacher;
import com.yuntu.uitl.pageUtil;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getPage(pageUtil pageUtil);

    int getCount();

    int add(Teacher t);

    int del(int id);

    int upd(Teacher t);

    Teacher getById(int id);
}
