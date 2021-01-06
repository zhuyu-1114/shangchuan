package com.yuntu.dao;

import com.yuntu.pojo.Scenicspot;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface ScenicspotMapper {
    List<Scenicspot> getPageAll(PageUtil pageUtil);

    int count();

    int delSce(int sid);

    int updSce(Scenicspot scenicspot);

    int addSce(Scenicspot scenicspot);

    Scenicspot selOneS(int sid);
}
