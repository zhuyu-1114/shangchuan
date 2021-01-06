package com.yuntu.biz;

import com.yuntu.pojo.Menu;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

public interface MenuBiz {
    public void getPage(PageUtil<Menu> pageUtil);

    public int addMenu(Menu menu);
    public int delMenu(@Param("mid") int mid);
    public Menu selMenu(@Param("mid") int mid);
    public int updMenu(Menu menu);
}
