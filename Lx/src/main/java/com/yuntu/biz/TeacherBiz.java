package com.yuntu.biz;

import com.yuntu.pojo.Teacher;
import com.yuntu.uitl.pageUtil;

public interface TeacherBiz {
    void getPage(pageUtil pageUtil);

    boolean  add(Teacher t);

    int del(int id);

    int upd(Teacher t);

    Teacher getById(int id);
}
