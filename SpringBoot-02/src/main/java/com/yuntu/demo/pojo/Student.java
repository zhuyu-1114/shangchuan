package com.yuntu.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件的值映射到这个组件里面
 * @ConfigurationProperties:告诉SpringBoot将当前类中的所有属性和配置文件中的相关属性进行绑定
 * @CpnfigurationProperties:默认从全局配置文件中读取的
 */

/*
* Component：将整体配置组件
* */
@Component
@ConfigurationProperties(prefix = "student")
@PropertySource(value = {"classpath:student.properties"})
//@Validated//数据校验：验证数据格式是否正确
public class Student {
    /*
    * @Value()相当于之前的
    * <bean>
        <property name="userName" value="字面量/${key}从配置文件中获取/#{Spring的表达式}"/>
    * </bean>
    * */
//    @Value("${student.userName}")
//    @Email
//    @NotEmpty
    private String UserName;
//    @Value("#{100*2}")
    private int age;
//    @Value("true")
    private boolean flag;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Pet pet;

    @Override
    public String toString() {
        return "Student{" +
                "UserName='" + UserName + '\'' +
                ", age=" + age +
                ", flag=" + flag +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", pet=" + pet +
                '}';
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Student() {
    }

    public Student(String UserName, int age, boolean flag, Date birth, Map<String, Object> maps, List<Object> lists, Pet pet) {
        this.UserName = UserName;
        this.age = age;
        this.flag = flag;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.pet = pet;
    }
}
