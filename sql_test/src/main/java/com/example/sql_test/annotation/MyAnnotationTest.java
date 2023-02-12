package com.example.sql_test.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName MyAnnotationTest
 * @Description TODO
 * @Author Summer_DM
 * @Date 2023/2/12 16:47
 * @Version 1.0
 */
public class MyAnnotationTest {
    private static ApplicationContext applicationContext;
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PriceService.class, args);
        PriceService priceService = (PriceService)run.getBean(PriceService.class);
        //PriceService priceService = (PriceService)applicationContext.getBean(PriceService.class);
        String test = priceService.test("4");
        String tes2 = priceService.test("");
        System.out.println("sdada"+test +tes2);
    }
}
