package com.yuntu.biz;

import com.yuntu.dao.StuinfoMapper;
import com.yuntu.pojo.Stuinfo;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("stuinfoBiz")
@Transactional
public class StuinfoBizImpl implements StuinfoBiz{
    @Autowired
    private StuinfoMapper stuinfoMapper;

    public StuinfoMapper getStuinfoMapper() {
        return stuinfoMapper;
    }

    public void setStuinfoMapper(StuinfoMapper stuinfoMapper) {
        this.stuinfoMapper = stuinfoMapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void getALl(PageUtil<Stuinfo> pageUtil) {
        int count = stuinfoMapper.getCount();
        if(count>0){
            pageUtil.setCounts(count);
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            int index = (pageUtil.getPageindex()-1)*pageUtil.getPagesize();
            int size = pageUtil.getPagesize();
            pageUtil.setLists(stuinfoMapper.getALl(index,size));
        }else{
            pageUtil.setLists(new ArrayList<Stuinfo>());
        }
    }

    @Override
    public boolean addStu(Stuinfo stuinfo) {
        if(stuinfoMapper.addStu(stuinfo)>0){
            return true;
        }
        return false;
    }
    @Override
    public boolean delStu(int stu_id) {
        if(stuinfoMapper.delStu(stu_id)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Stuinfo selStu(int stu_id) {
        return stuinfoMapper.selStu(stu_id);
    }

    @Override
    public boolean updStu(Stuinfo stuinfo) {
        if(stuinfoMapper.updStu(stuinfo)>0){
            return true;
        }
        return false;
    }
}
