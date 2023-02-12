package com.example.sql_test.annotation;

import java.lang.annotation.*;

/**
 * @ClassName MyAnnotation
 * @Description TODO
 * @Author Summer_DM
 * @Date 2023/2/12 16:08
 * @Version 1.0
 */
//java 在生成文档时  是否显示注解的开关
@Documented
//说明了该注解所修饰的对象范围
@Target({ElementType.METHOD,ElementType.FIELD})
//指定  注解不仅仅被保存在class文件中，JVM加载class文件之后，任然存在
@Retention(RetentionPolicy.RUNTIME)
//被此注解修饰的注解，会自动遗传给其子类，这里写了只作说明，用处不大
@Inherited
public @interface  MyAnnotation {

    //定义一个name属性
    String name();
    //定义一个 属性 表明注解的类型
    AnnotationType type();
}
