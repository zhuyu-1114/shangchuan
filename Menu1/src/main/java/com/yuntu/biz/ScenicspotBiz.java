package com.yuntu.biz;

import com.yuntu.pojo.Scenicspot;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface ScenicspotBiz {
    void getPageAll(PageUtil pageUtil);

    int delSce(int sid);

    int updSce(Scenicspot scenicspot);

    int addSce(Scenicspot scenicspot);

    Scenicspot selOneS(int sid);
}
