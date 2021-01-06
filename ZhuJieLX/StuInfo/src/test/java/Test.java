import com.yuntu.biz.StuInfoBiz;
import com.yuntu.pojo.Sex;
import com.yuntu.pojo.StuInfo;
import com.yuntu.util.PageUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Test {
    @org.junit.Test
    public void getPage(){
        ApplicationContext application =  new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz = (StuInfoBiz) application.getBean("stuInfoBiz");
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageindex(1);
        pageUtil.setPagesize(2);
        biz.getPage(pageUtil);
        List<StuInfo> stuinfos = pageUtil.getLists();
        for(StuInfo s:stuinfos){
            System.out.println(s.toString()+"\n");
        }
    }
    @org.junit.Test
    public void addStuInfo(){
        ApplicationContext application =  new ClassPathXmlApplicationContext("applicationContext.xml");
        StuInfoBiz biz = (StuInfoBiz) application.getBean("stuInfoBiz");
        StuInfo stuInfo = new StuInfo("li","123",2,"2","123","123");
        if(biz.add(stuInfo)){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}
