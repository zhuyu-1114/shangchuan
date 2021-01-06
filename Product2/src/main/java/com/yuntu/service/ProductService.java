package com.yuntu.service;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Product;
import org.apache.ibatis.annotations.Param;


public interface ProductService {
    void getPage(PageUtil pageUtil);
    boolean addPro(Product product);
    boolean updPro(Product product);
    boolean delPro(@Param("id") int id);
    Product selPro(@Param("id") int id);
}
