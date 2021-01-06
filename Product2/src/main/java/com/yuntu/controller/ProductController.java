package com.yuntu.controller;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.Product;
import com.yuntu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("pro")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }

    @RequestMapping("/getPage")
    @ResponseBody
    public PageUtil getPage(String pageindex){
        if(pageindex==null || "".equals(pageindex)){
            pageindex="1";
        }
        if(Integer.parseInt(pageindex)>1){
            pageindex="1";
        }
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageindex(Integer.parseInt(pageindex));
        pageUtil.setPagesize(3);
        productService.getPage(pageUtil);
        return pageUtil;
    }
    @RequestMapping("/add.html")
    public String add(){
        return "add";
    }
    @RequestMapping("/add")
    public String addUser(Product product){
        Product product1 = new Product(product.getId(),product.getName(),product.getPrice(),product.getStock(),product.getFileName(),product.getTypeId());
        if (productService.addPro(product1)){
            return "index";
        }
        return "add.html";
    }
    @RequestMapping("/del/{id}")
    @ResponseBody
    public Boolean delUser(@PathVariable String id){
        return productService.delPro(Integer.parseInt(id));
    }

    @RequestMapping("/upd")
    public String updUser(String id,String name,int price,int stock,String fileName,int typeId){
        Product product = new Product(Integer.parseInt(id),name,price,stock,fileName,typeId);
        if (productService.updPro(product)){
            return "index";
        }
        return "update.html";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Product getOne(int id){
        return productService.selPro(id);
    }
    @RequestMapping("/update.html")
    public String getUser(String id, Model model){
        model.addAttribute("id",id);
        return "update";
    }
}
