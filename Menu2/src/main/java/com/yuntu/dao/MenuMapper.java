package com.yuntu.dao;

import com.yuntu.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    public List<Menu> getPage(@Param("index") int index, @Param("size") int size);
    public int getCount();

    public int addMenu(Menu menu);
    public int delMenu(@Param("mid") int mid);
    public Menu selMenu(@Param("mid") int mid);
    public int updMenu(Menu menu);
}
