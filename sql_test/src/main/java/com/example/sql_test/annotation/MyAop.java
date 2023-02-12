package com.example.sql_test.annotation;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MyAop
 * @Description TODO  定义切面的功能
 * @Author Summer_DM
 * @Date 2023/2/12 16:17
 * @Version 1.0
 */
@Aspect
@Component
public class MyAop {

    @Pointcut("@annotation(com.example.sql_test.annotation.MyAnnotation)")
    private void myAnnotation() {
    }
    @Around("myAnnotation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, MyAnnotation myAnnotation){
        System.out.println("开始进入切面。。。。。");
        Object result = null;
        long startTime = System.currentTimeMillis();
        //用来统计调用次数
        Long count = 0l;
        try {
            System.out.println("开始调用方法  入参 = "+ JSON.toJSONString(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            System.out.println("结束调用方法  返回 = "+ result);
        } catch (Throwable e) {
            System.out.println("接口异常：" + e);
            e.printStackTrace();
        }
        Set<AnnotationType> annotationTypes =  new HashSet<>();
        annotationTypes.add(myAnnotation.type());
        if (annotationTypes.contains(AnnotationType.TIMER)){
            System.out.println("接口响应时间：" + (System.currentTimeMillis() - startTime) + "ms");
        }
        if (annotationTypes.contains(AnnotationType.COUNTER)){
            count++;
            System.out.println("接口调用次数：" + count + "次");
        }
        return result;
    }


    @Before("myAnnotation()")
    public void record(JoinPoint joinPoint) {
        System.out.println("Before");
    }

    @After("myAnnotation()")
    public void after() {
        System.out.println("After");
    }
}
