package com.yuntu.dao;


import com.yuntu.pojo.Peitems;
import com.yuntu.uitl.pageUtil;

import java.util.List;

public interface PeitemsMapper {
    //分页
    List<Peitems> getPage(pageUtil pageUtil);
    //查询总数
    int getCount();
    //添加
    int add(Peitems p);
    //删除
    int del(int id);
    //修改
    int upd(Peitems p);
    //查询单个
    Peitems getById(int id);
}
