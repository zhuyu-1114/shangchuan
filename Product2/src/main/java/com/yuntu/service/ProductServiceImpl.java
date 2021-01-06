package com.yuntu.service;

import com.yuntu.dao.ProductMapper;
import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductMapper productMapper;

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public void getPage(PageUtil pageUtil) {
        int count =productMapper.getCount();
        pageUtil.setCounts(count);
        if(count>0){
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            List<Product> list = productMapper.getPage(pageUtil);
            pageUtil.setLists(list);
        }else {
            List<Product> list = new ArrayList<Product>();
        }
    }

    @Override
    public boolean addPro(Product product) {
        if(productMapper.addPro(product)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updPro(Product product) {
        if(productMapper.updPro(product)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delPro(int id) {
        if(productMapper.delPro(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public Product selPro(int id) {
        return productMapper.selPro(id);
    }
}
