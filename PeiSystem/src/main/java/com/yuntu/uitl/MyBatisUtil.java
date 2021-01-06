package com.yuntu.uitl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    public static SqlSessionFactory factory;
    static {//静态代码块:运行在应用的最前面，且只运行一次 factory
        System.out.print("----开始创建factory对象-----");
        try {
            //        1.获取mybatis-cpmfog.xml的文件流
            InputStream is = Resources.getResourceAsStream("mybatia-config.xml");
//        2.创建SqlSessionfactroy工厂对象
            factory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    创建的方法 打开sqlsession
    public static SqlSession createSqlsession(){
        //        3.根据工厂创建sqlsession对象 true自动提交
        return factory.openSession(false);
    }

//    关闭sqlsession
    public static void closeSqlsession(SqlSession s){
        if(null!=s){
            s.close();
        }
    }
}
