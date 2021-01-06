package com.yuntu.cotroller;

import com.yuntu.pojo.Probuct;
import com.yuntu.service.ProbuctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pro")
public class ProbuctController {

    @Autowired
    ProbuctService probuctService;

    @RequestMapping("getAll")
    @ResponseBody
    public List<Probuct> getAll(){
        List<Probuct> probucts = probuctService.getAll();
        return probucts;
    }
    @RequestMapping("add")
    public String add(){
        return "add";
    }

    String a="";
    public boolean saveFile(MultipartFile file,String path){
        if(!file.isEmpty()){
            try {
                File filePath = new File(path);
                if(!filePath.exists()){
                    filePath.mkdirs();
                }
                a+=file.getOriginalFilename();
                String savePath = path+file.getOriginalFilename();
                file.transferTo(new File(savePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    @RequestMapping("addfile")
    public String addfile(@RequestParam("files") MultipartFile[] files,String name,String price){
        a="";
        String path = "E:\\IDea\\FileLx\\src\\main\\webapp\\img\\";
        if(files!=null&files.length>0){
            for (int i=0;i<files.length;i++){
                MultipartFile file = files[i];
                if(i!=0){
                    a+=",";
                }
                //保存文件
                saveFile(file,path);
            }
        }
        Probuct probuct = new Probuct(name,Integer.parseInt(price),a);
        probuctService.addPro(probuct);
        return "redirect:/pro/index";
    }
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
