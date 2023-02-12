package com.example.sql_test.annotation;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName PriceService
 * @Description TODO
 * @Author Summer_DM
 * @Date 2023/2/12 16:47
 * @Version 1.0
 */
@Service
public class PriceService {

    @MyAnnotation(name = "PriceService.test",type = AnnotationType.COUNTER)
    public String test(String s){
        int time = 0;
        if (Objects.nonNull(s)){
            time ++;
            return "调用注解成功" + time;
        }
        return "调用成功，参数为空";
    }
}
