package com.yuntu.service.impl;

import com.yuntu.dao.StudentMapper;
import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Student;
import com.yuntu.pojo.User;
import com.yuntu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl  implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void getPage(PageUtil pageUtil) {
        int count = studentMapper.getCount();
        if(count>0){
            pageUtil.setCounts(count);
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<Student> list = studentMapper.getPage(pageUtil);
            pageUtil.setLists(list);
        }else{
            List<Student> list = new ArrayList<Student>();
        }
    }

    @Override
    public boolean addStu(Student student) {
        if(studentMapper.addStu(student)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delStu(int id) {
        if(studentMapper.delStu(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updStu(Student student) {
        if(studentMapper.updStu(student)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Student selStu(int id) {
        return studentMapper.selStu(id);
    }
}
