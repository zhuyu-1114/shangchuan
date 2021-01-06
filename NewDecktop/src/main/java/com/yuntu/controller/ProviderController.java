package com.yuntu.controller;

import com.yuntu.pojo.Bill;
import com.yuntu.pojo.Provider;
import com.yuntu.pojo.User;
import com.yuntu.service.provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    private  ProviderService providerService;

    @RequestMapping("/providerAll")
    @ResponseBody
    public List<Provider> getProviderAll(){
        return providerService.getProviderAll();
    }

    @RequestMapping("/providerList")
    public String localProviderList(){
        return "providerlist";
    }

    @RequestMapping("/providerView")
    public String providerView(String id, Model model){
        model.addAttribute("id",id);
        return "providerview";
    }


    @RequestMapping("/delProvider")
    @ResponseBody
    public boolean delProviderById(String id){
        return providerService.delProviderById(Integer.parseInt(id));
    }

    @RequestMapping("/getProvider")
    @ResponseBody
    public Provider getProvider(String id){
        return providerService.getProviderById(Integer.parseInt(id));
    }

    @RequestMapping("/addProvider")
    public String localAddProvider(){
        return "provideradd";
    }

    @RequestMapping("/addProvider.do")
    public String addProvider(String proCode,String proName,String proContact,String proPhone,String proAddress,String proFax,String proDesc,HttpSession session){
        User user = (User) session.getAttribute("user");
        Provider provider = new Provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,user.getId(),new Date());
        boolean addflag = providerService.addProvider(provider);
        if (addflag){
            return "redirect:providerList";
        }
        return "redirect:error";
    }
    @RequestMapping("/updateProvider")
    public String updateProvider(String id, Model model){
        model.addAttribute("id",id);
        return "providermodify";
    }

    @RequestMapping("/updProvider.do")
    public String updProvider(String id,String proCode,String proName,String proContact,String proPhone,String proAddress,String proFax,String proDesc,HttpSession session){
        User user = (User) session.getAttribute("user");
        Provider provider = new Provider(Integer.parseInt(id),proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,new Date(),user.getId());
        boolean updflag = providerService.updProvider(provider);
        if (updflag){
            return "redirect:providerList";
        }
        return "error";
    }

    @RequestMapping("/getProviderByCondition")
    @ResponseBody
    public List<Provider> getBillByCondition(String proCode,String proName){
        return providerService.getProviderByCondition(proCode,proName);
    }
}
