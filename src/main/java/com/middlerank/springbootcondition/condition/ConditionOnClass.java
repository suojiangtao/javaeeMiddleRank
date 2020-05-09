package com.middlerank.springbootcondition.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author SuoJiangTao
 * 自定义注解以方便动态的实现条件
 * Target 表示是作用注解可以在那个范围加载类上边和方法上边
 * retention 表示什么时候起作用
 * Documented 表示java生成的doc文档
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ClassCondition.class)
public @interface ConditionOnClass {
    String [] value();
}
