package com.yuntu.dao;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    List<Product> getPage(PageUtil pageUtil);
    int getCount();
    int addPro(Product product);
    int updPro(Product product);
    int delPro(@Param("id") int id);
    Product selPro(@Param("id") int id);
}
