package com.middlerank.springbootcondition.config;

import com.middlerank.springbootcondition.condition.ClassCondition;
import com.middlerank.springbootcondition.condition.ConditionOnClass;
import com.middlerank.springbootcondition.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author SuoJiangTao
 */
@Configuration
public class UserConfig {
    @Bean
//    @Conditional(ClassCondition.class)
//    @ConditionOnClass("redis.clients.jedis.Jedis")
    public User user(){
        return new User();
    }

    //ConditionalOnProperty 指定只有当你配置文件里边有一个键叫itcast 值heima 的时候 才会加载对应的Bean
    @Bean
    @ConditionalOnProperty(name = "itcast",havingValue = "heima")
    public User user1(){
        return new User();
    }

}
