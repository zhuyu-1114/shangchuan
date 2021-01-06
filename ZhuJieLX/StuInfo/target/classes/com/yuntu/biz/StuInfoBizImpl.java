package com.yuntu.biz;

import com.yuntu.dao.StuInfoMapper;
import com.yuntu.pojo.StuInfo;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
@Service("stuInfoBiz")

public class StuInfoBizImpl implements StuInfoBiz{

    @Autowired
    StuInfoMapper stuInfoMapper;

    public StuInfoMapper getStuInfoMapper() {
        return stuInfoMapper;
    }

    public void setStuInfoMapper(StuInfoMapper stuInfoMapper) {
        this.stuInfoMapper = stuInfoMapper;
    }

    @Override
    public void getPage(PageUtil<StuInfo> pageUtil) {
        int count = stuInfoMapper.count();
        if(count>0){
            pageUtil.setCounts(count);
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(stuInfoMapper.getPage(pageUtil));
        }else {
            pageUtil.setLists(new ArrayList<>());
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public boolean add(StuInfo stuInfo) {
        if (stuInfoMapper.add(stuInfo)>0){
            return true;
        }
        return true;
    }

    @Override
    public boolean del(int stu_id) {
        if (stuInfoMapper.del(stu_id)>0){
            return true;
        }
        return true;
    }

    @Override
    public boolean upd(StuInfo stuInfo) {
        if (stuInfoMapper.upd(stuInfo)>0){
            return true;
        }
        return true;
    }

    @Override
    public StuInfo getOne(int stu_id) {
        return stuInfoMapper.getOne(stu_id);
    }
}
