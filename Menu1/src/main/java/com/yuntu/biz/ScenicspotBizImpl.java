package com.yuntu.biz;

import com.yuntu.dao.ScenicspotMapper;
import com.yuntu.pojo.Scenicspot;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ScenicspotBiz")
public class ScenicspotBizImpl implements ScenicspotBiz {

    @Autowired
    private ScenicspotMapper scenicspotMapper;

    @Override
    public void getPageAll(PageUtil pageUtil) {
        int count = scenicspotMapper.count();
        pageUtil.setCounts(count);
        if(count>0){
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<Scenicspot> list = scenicspotMapper.getPageAll(pageUtil);
            pageUtil.setLists(list);
        }else{
            pageUtil.setLists(new ArrayList<Scenicspot>());
        }
    }

    @Override
    public int delSce(int sid) {
        return scenicspotMapper.delSce(sid);
    }

    @Override
    public int updSce(Scenicspot scenicspot) {
        return scenicspotMapper.updSce(scenicspot);
    }

    @Override
    public int addSce(Scenicspot scenicspot) {
        return scenicspotMapper.addSce(scenicspot);
    }

    @Override
    public Scenicspot selOneS(int sid) {
        return scenicspotMapper.selOneS(sid);
    }

    public ScenicspotMapper getScenicspotMapper() {
        return scenicspotMapper;
    }

    public void setScenicspotMapper(ScenicspotMapper scenicspotMapper) {
        this.scenicspotMapper = scenicspotMapper;
    }
}
