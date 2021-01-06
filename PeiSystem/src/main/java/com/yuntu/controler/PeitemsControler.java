package com.yuntu.controler;

import com.yuntu.biz.PeitemsBiz;
import com.yuntu.pojo.Peitems;
import com.yuntu.uitl.pageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Peitems")
public class PeitemsControler {
    @Autowired
    PeitemsBiz peitemsBiz;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/getPage")
    @ResponseBody
    public pageUtil getPage(String pageIndex){
//        需要优化，会使用分页工具，会使用json传输数据
        if(pageIndex==null || "".equals(pageIndex)){
            pageIndex = "1";
        }
        if(Integer.parseInt(pageIndex)<1){
            pageIndex = "1";
        }
        pageUtil pageutil = new pageUtil();
        pageutil.setPageindex(Integer.parseInt(pageIndex));
        pageutil.setPagesize(2);
        peitemsBiz.getPage(pageutil);
        return pageutil;
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    //    spring是支持对象传递
    @RequestMapping("/addstu")
    public String addstu(String itemname,int typeid,int necessary,String ref,double price,String info){
        if(peitemsBiz.add(new Peitems(itemname,typeid,necessary,ref,price,info))){
            return "index";
        }else{
            return "add";
        }
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Boolean del(@PathVariable String id){
        if(peitemsBiz.del(Integer.parseInt(id))!=0){
            return true;
        }
        return false;
    }

    @RequestMapping("/update")
    public String selone(int id,Model model){
        model.addAttribute("id",id);
        return "update";
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Peitems getone(int id){
        return peitemsBiz.getById(id);
    };

    @RequestMapping("/upd")
    public String upd(int id,String itemname,int typeid,int necessary,String ref,double price,String info){
        if(peitemsBiz.upd(new Peitems(id,itemname,typeid,necessary,ref,price,info))!=0){
            return "index";
        }else{
            return "update";
        }
    }
}
