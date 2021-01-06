package test;

import entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.PublicKey;

public class ReflectTest {

    //反射机制：在运行状态中，
    //动态的获取信息以及动态的调用对象方法的功能
    //java编译流程：xxx.java -> 编译器 -> xxx.class ->虚拟机->
    //不确定那个类被加载了，在程序运行时才加载
    //java反射：? -> 编译器 -> 运行程序
    @Test
    public void Test1(){
        //通过最原始的方法来创建对象，调用对象
        Person p = new Person();
        p.setAge(1);
        p.setName("朱");
        System.out.println(p.toString());

        p.show();
        p.display("CN");
    }
    //反射机制创建
    @Test
    public void Test2() throws Exception{
        Class clazz =  Person.class;
        //1.创建对应的对象
        Person p = (Person) clazz.newInstance();
        System.out.println(p);
        //2.直接拿到实例里的所以属性和方法
        Field f1 = clazz.getField("name");
        f1.set(p,"周易");
        Field f2 = clazz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p,2);
        System.out.println(p);

        //3.调用指定的方法
        Method m1 = clazz.getMethod("show");
        m1.invoke(p);

        Method m2 = clazz.getMethod("display", String.class);
        m2.invoke(p,"CN");
    }
    @Test
    public void Test3() throws Exception{
        //实例化的三种方式(重点*)
        //1.调用类的class属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //2.对象的getClass方法
        Person person = new Person();
        Class clazz2 = person.getClass();
        //3.Class的forName的静态方法
        Class clazz3 =  Class.forName("entity.Person");
    }
    @Test
    public void Test4() throws Exception{
        //有了Class实例：可以干什么？
        //1.创建运行时类的对象（重点*）
        Class clazz1 = Class.forName("entity.Person");
        Person person = (Person) clazz1.newInstance();
        //2.通过构造创建
        Class clazz2 = Person.class;
        Constructor constructor = clazz2.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        Person p = (Person)constructor.newInstance("南南",2);
        System.out.println(p);
    }
    @Test
    public void Test5() throws Exception{
        Class<Person> clazz1 = Person.class;
        Person p = clazz1.newInstance();
        //调用运行时类的指定结构(属性，方法，构造)
        //1.属性
        //punlic修饰
        Field f1 = clazz1.getField("name");
        f1.set(p,"阿萨");

        //非public修饰
        Field f2 = clazz1.getField("age");
        f2.setAccessible(true);
        f2.set(p,5);
        System.out.println(p);
    }
    @Test
    public void Test6() throws Exception{
        Class<Person> clazz1 = Person.class;
        Person p = clazz1.newInstance();
        //1.方法
        //无参
        Method m1 = clazz1.getMethod("show");
        //有参
        Method m2 = clazz1.getMethod("display", String.class);

        //是否是public方法getDeclaredConstructor

        //静态代理
        
        //动态代理
    }
}
