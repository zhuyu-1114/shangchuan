package com.yuntu.demo;

import com.yuntu.demo.pojo.Pet;
import com.yuntu.demo.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Student student;

//    @Autowired
//    @Qualifier("pet")

    @Autowired
    Pet pet;

    @Test
    void contextLoads() {
        System.out.println(student.toString());
    }

}
