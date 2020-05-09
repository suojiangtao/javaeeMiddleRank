package com.middlerank.springbootcondition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootConditionApplication {

    public static void main(String[] args) {
        /* 从启动类上获取到spring容器 */
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootConditionApplication.class, args);
//        //获取Bean 需要导入依赖，不然会报错的
//        Object redisTemplate = context.getBean("redisTemplate");
//        System.out.println(redisTemplate);

        Object user = context.getBean("redisTemplate");
        System.out.println(user);
    }

}
