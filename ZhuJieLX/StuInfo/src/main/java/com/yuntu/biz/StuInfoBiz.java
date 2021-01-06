package com.yuntu.biz;

import com.yuntu.dao.StuInfoMapper;
import com.yuntu.pojo.StuInfo;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

public interface StuInfoBiz {
    void getPage(PageUtil<StuInfo> pageUtil);
    boolean add(StuInfo stuInfo);
    boolean del(@Param("stu_id") int stu_id);
    boolean upd(StuInfo stuInfo);
    StuInfo getOne(@Param("stu_id") int stu_id);
}
