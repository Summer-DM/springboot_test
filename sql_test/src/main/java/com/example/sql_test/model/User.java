package com.example.sql_test.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/8/21 9:00
 * @Version 1.0
 */
@Data
public class User {
    private long id;
    private String userName;
    private String tel;
    private String sex;
    private int age;
    private String addr;

}
