package com.example.sql_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlTestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        byte a = 127;
        a += 7;
        System.out.println(a);
    }

}
