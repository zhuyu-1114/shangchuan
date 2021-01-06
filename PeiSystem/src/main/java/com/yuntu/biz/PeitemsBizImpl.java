package com.yuntu.biz;

import com.yuntu.dao.PeitemsMapper;
import com.yuntu.pojo.Peitems;
import com.yuntu.uitl.pageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PeitemsBiz")
public class PeitemsBizImpl implements PeitemsBiz {
    @Autowired
    private PeitemsMapper peitemsMapper;

    public PeitemsMapper getTeacherMapper() {
        return peitemsMapper;
    }

    public void setTeacherMapper(PeitemsMapper teacherMapper) {
        this.peitemsMapper = teacherMapper;
    }

    public PeitemsBizImpl() {
    }

    @Override
    public void getPage(pageUtil pageUtil) {
        int count=peitemsMapper.getCount();
        pageUtil.setCounts(count);
        if(count>0){
            //右边界
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<Peitems> list=peitemsMapper.getPage(pageUtil);
            pageUtil.setLists(list);
        }else {
            pageUtil.setLists(new ArrayList<Peitems>());
        }
    }

    @Override
    public boolean add(Peitems t) {
        if(peitemsMapper.add(t)!=0){
            return true;
        }
        return false;
    }

    @Override
    public int del(int id) {
        return peitemsMapper.del(id);
    }

    @Override
    public int upd(Peitems t) {
        return peitemsMapper.upd(t);
    }

    @Override
    public Peitems getById(int id) {
        return peitemsMapper.getById(id);
    }
}
