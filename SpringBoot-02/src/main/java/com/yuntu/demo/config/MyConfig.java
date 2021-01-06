package com.yuntu.demo.config;

import com.yuntu.demo.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration/*将本类变成配置文件*/
public class MyConfig {

    //将方法的返回值添加到容器里
    //容器中默认id就是方法名
    @Bean
    public Pet pet(){
        System.out.println("配置类@Bean给容器中添加了组件");
        return new Pet("鱼鱼",18);
    }
}
