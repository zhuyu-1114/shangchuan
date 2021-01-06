package com.yuntu.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {
    /*
    * 保存文件的方法
    * */
    public boolean saveFile(MultipartFile file,String path){
        //判断是否为空
        if(!file.isEmpty()){
            try {
                File filePath = new File(path);
                //判断文件夹是否存在
                if(!filePath.exists()){
                    filePath.mkdirs();
                }
                String savePath = path+file.getOriginalFilename();
                file.transferTo(new File(savePath));
                System.out.println("成功");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("失败");
            }
        }
        return false;
    }
    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file")MultipartFile[] files){
        String path = "E:/File/";
        if(files!=null&files.length>0){
            for (int i=0;i<files.length;i++){
                MultipartFile file = files[i];
                //保存文件的方法
                saveFile(file,path);
            }
        }
        //重定向
        return "redirect:/index.jsp";
    }
}
