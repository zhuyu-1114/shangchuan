package com.yuntu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    public static SqlSessionFactory factory;//全局作用域
    static {//静态代码块：运行在应用的最前面，且只运行有一次 factory

        System.out.println("-----------创建对象-----------");
        try {
            //1获取MyBatis-config.xml的文件流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //2创建SqlSessionfactory工厂对象
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    * 打开SqlSession
    * */
    public static SqlSession createSqlSession(){
        //3创建sqlsession
        return factory.openSession(false);
    }
    /*
    * 关闭SqlSessiom
    * */
    public static void closeSqlSession(SqlSession sqlSession){
        if(null!=sqlSession){
            sqlSession.close();
        }
    }
}
