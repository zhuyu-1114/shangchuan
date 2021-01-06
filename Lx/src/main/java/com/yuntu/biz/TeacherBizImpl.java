package com.yuntu.biz;

import com.yuntu.dao.TeacherMapper;
import com.yuntu.pojo.Teacher;
import com.yuntu.uitl.pageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TeacherBiz")
public class TeacherBizImpl implements TeacherBiz {
    @Autowired
    private TeacherMapper teacherMapper;

    public TeacherMapper getEmployeeMapper() {
        return teacherMapper;
    }

    public void setEmployeeMapper(TeacherMapper employeeMapper) {
        this.teacherMapper = employeeMapper;
    }

    public TeacherBizImpl() {
    }

    @Override
    public void getPage(pageUtil pageUtil) {
        int count=teacherMapper.getCount();
        pageUtil.setCounts(count);
        if(count>0){
            //右边界
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<Teacher> list=teacherMapper.getPage(pageUtil);
            pageUtil.setLists(list);
        }else {
            pageUtil.setLists(new ArrayList<Teacher>());
        }
    }

    @Override
    public boolean add(Teacher t) {
        if(teacherMapper.add(t)!=0){
            return true;
        }
        return false;
    }

    @Override
    public int del(int id) {
        return teacherMapper.del(id);
    }

    @Override
    public int upd(Teacher t) {
        return teacherMapper.upd(t);
    }

    @Override
    public Teacher getById(int id) {
        return teacherMapper.getById(id);
    }
}
