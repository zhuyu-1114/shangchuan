package dao.student;

import org.apache.ibatis.annotations.Param;
import pojo.PageUtil;
import pojo.Student;

import java.util.List;

public interface StudentMapper {

    //分页
    List<Student> getPage(PageUtil pageUtil);

    //查询总数
    int Count();

    //增加
    int addStu(Student student);

    //删除
    int delStu(int id);

    //修改
    int updStu(Student student);

    //查询单个
    Student getStuById(int id);
}
