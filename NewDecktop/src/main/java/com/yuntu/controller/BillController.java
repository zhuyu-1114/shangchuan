package com.yuntu.controller;

import com.yuntu.pojo.Bill;
import com.yuntu.pojo.User;
import com.yuntu.service.bill.BillService;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("bill")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping("/billList")
    public String localBillList(){
        return "billlist";
    }

    @RequestMapping("/addBill")
    public String localAddBill(){
        return "billadd";
    }

    @RequestMapping("/addBill.do")
    public String addBill(String billCode,String productName,String productUnit, String productCount, String totalPrice ,String providerId ,String isPayment,HttpSession session){
        Double pCount = Double.parseDouble(productCount);
        Double tPrice = Double.parseDouble(totalPrice);
        int pId = Integer.parseInt(providerId);
        int isPay = Integer.parseInt(isPayment);
        User user = (User) session.getAttribute("user");
        Bill bill = new Bill(billCode,productName,"111",productUnit,pCount,tPrice,isPay,user.getId(),new Date(),pId);
        boolean addflag = billService.addBill(bill);
        if (addflag){
            return "redirect:billList";
        }
        return "redirect:error";
    }

    @RequestMapping("/getBillPage")
    @ResponseBody
    public PageUtil<Bill> getBillPage(String pageindex){
        if (pageindex.equals("") || pageindex==null){
            pageindex="1";
        }
        int index = Integer.parseInt(pageindex);
        if (index<1){
            index=1;
        }
        PageUtil<Bill> pageUtil = new PageUtil<Bill>();
        pageUtil.setPageindex(index);
        pageUtil.setPagesize(99999999);
        billService.getPageAll(pageUtil);
        return pageUtil;
    }

    @RequestMapping("/delBill")
    @ResponseBody
    public boolean delBillById(String id){
        return billService.delBillById(Integer.parseInt(id));
    }

    @RequestMapping("/billView")
    public String billView(String id, Model model){
        model.addAttribute("id",id);
        return "billview";
    }

    @RequestMapping("/updateBill")
    public String updateBill(String id, Model model){
        model.addAttribute("id",id);
        return "billmodify";
    }

    @RequestMapping("/updBill.do")
    public String updBill(String id,String billCode,String productName,String productUnit, String productCount, String totalPrice ,String providerId ,String isPayment,HttpSession session){
        Double pCount = Double.parseDouble(productCount);
        Double tPrice = Double.parseDouble(totalPrice);
        int pId = Integer.parseInt(providerId);
        int isPay = Integer.parseInt(isPayment);
        User user = (User) session.getAttribute("user");
        Bill bill = new Bill(Integer.parseInt(id),billCode,productName,"111",productUnit,pCount,tPrice,isPay,user.getId(),new Date(),pId);
        boolean updflag = billService.updBill(bill);
        if (updflag){
            return "redirect:billList";
        }
        return "error";
    }

    @RequestMapping("/getBill")
    @ResponseBody
    public Bill getBill(String id){
        return billService.getBillById(Integer.parseInt(id));
    }

    @RequestMapping("/getBillByCondition")
    @ResponseBody
    public List<Bill> getBillByCondition(String productName,String providerId,String isPayment){
        return billService.getBillByCondition(productName,Integer.parseInt(providerId),Integer.parseInt(isPayment));
    }
}
