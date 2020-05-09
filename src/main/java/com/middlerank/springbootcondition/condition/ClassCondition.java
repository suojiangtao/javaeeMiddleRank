package com.middlerank.springbootcondition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @author suojiangtao
 * 条件判断实现condition 里面的方法会返回一个boolean值，true表示容器会帮你创建，false则不会
 */
public class ClassCondition implements Condition {


    /**
     * 需求导入jedis坐标后 才创建user实例
     * @param context  上下文 可以用来获取上下文对象 ，用于获取坏境 ，Ioc容器 ClassLoader 对象
     * @param metadata 注解元对象  可以用于获取注解定义的属性值
     * @return boolean
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        /**
//         * 判断forName是否存在 不存在会走cach
//         */
//        boolean flag=true;
//        try {
//            Class<?> forName = Class.forName("redis.clients.jedis.Jedis");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            flag=false;
//        }
//        return flag;
//  }

        //需求2 导入通过注解属性值value指定的坐标后创建bean
        //获取注解属性值
        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        System.out.println(map); //{value:{redis.client.jedis.jedis}}
        String[] value = (String[]) map.get("value");



        boolean flag=true;
        try {
            for (String className : value) {
                Class<?> forName = Class.forName(className);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            flag=false;
        }
        return flag;
  }
}
