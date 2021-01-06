package com.yuntu.biz;

import com.yuntu.pojo.Peitems;
import com.yuntu.uitl.pageUtil;

public interface PeitemsBiz {
    //分页
    void getPage(pageUtil pageUtil);
    //添加
    boolean  add(Peitems t);
    //删除
    int del(int id);
    //修改
    int upd(Peitems t);
    //查询单个
    Peitems getById(int id);
}
