import com.yuntu.biz.StuinfoBiz;
import com.yuntu.pojo.Stuinfo;
import com.yuntu.util.PageUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public void getAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuinfoBiz biz = (StuinfoBiz)applicationContext.getBean("stuinfoBiz");
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageindex(1);
        pageUtil.setPagesize(2);
        biz.getALl(pageUtil);
        List<Stuinfo> stuinfos = pageUtil.getLists();
        for(Stuinfo s:stuinfos){
            System.out.println(s.toString());
        }
    }
    @org.junit.Test
    public void addStu(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuinfoBiz biz = (StuinfoBiz)applicationContext.getBean("stuinfoBiz");
        Stuinfo s = new Stuinfo("8","4",2,"4","4","4");
        if(biz.addStu(s)){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
    @org.junit.Test
    public void updStu(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuinfoBiz biz = (StuinfoBiz)applicationContext.getBean("stuinfoBiz");
        Stuinfo s = new Stuinfo(1,"4","4",2,"4","4","4");
        if(biz.updStu(s)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    @org.junit.Test
    public void delStu(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuinfoBiz biz = (StuinfoBiz)applicationContext.getBean("stuinfoBiz");
        if(biz.delStu(2)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    @org.junit.Test
    public void selStu(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuinfoBiz biz = (StuinfoBiz)applicationContext.getBean("stuinfoBiz");
        Stuinfo stuinfos = biz.selStu(1);
        System.out.println(stuinfos.toString());
    }
}
