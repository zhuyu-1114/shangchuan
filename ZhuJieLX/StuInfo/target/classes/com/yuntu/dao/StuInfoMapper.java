package com.yuntu.dao;

import com.yuntu.pojo.StuInfo;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuInfoMapper {
    int count();
    List<StuInfo> getPage(PageUtil<StuInfo> pageUtil);
    int add(StuInfo stuInfo);
    int del(@Param("stu_id") int stu_id);
    int upd(StuInfo stuInfo);
    StuInfo getOne(@Param("stu_id") int stu_id);

}
