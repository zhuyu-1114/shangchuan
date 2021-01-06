package service.impl;

import dao.student.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.PageUtil;
import pojo.Student;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

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
        int count = studentMapper.Count();
        pageUtil.setCounts(count);
        if(count>0){
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<Student> list = studentMapper.getPage(pageUtil);
            pageUtil.setLists(list);
        }else{
            pageUtil.setLists(new ArrayList<Student>());
        }
    }

    @Override
    public int addStu(Student student) {
        if(studentMapper.addStu(student)>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int delStu(int id) {
        if(studentMapper.delStu(id)>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int updStu(Student student) {
        if(studentMapper.updStu(student)>0){
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Student getStuById(int id) {
        return studentMapper.getStuById(id);
    }
}
