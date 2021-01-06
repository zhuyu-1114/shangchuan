package com.yuntu.dao;

import com.yuntu.pojo.Stuinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuinfoMapper {
    public List<Stuinfo> getALl(@Param("index") int index, @Param("size") int size);
    public int getCount();

    public int addStu(Stuinfo stuinfo);
    public int delStu(@Param("stu_id") int stu_id);
    public Stuinfo selStu(@Param("stu_id") int stu_id);
    public int updStu(Stuinfo stuinfo);
}
