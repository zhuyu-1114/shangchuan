package com.yuntu.biz;

import com.yuntu.pojo.Stuinfo;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuinfoBiz {
    public void getALl(PageUtil<Stuinfo> pageUtil);
    public boolean addStu(Stuinfo stuinfo);
    public boolean delStu(int stu_id);
    public Stuinfo selStu(int stu_id);
    public boolean updStu(Stuinfo stuinfo);
}
