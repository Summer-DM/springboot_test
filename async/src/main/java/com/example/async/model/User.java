package com.example.async.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 14:44
 * @Version 1.0
 */
@Data
@ToString
public class User {
    private Long id;
    private String userName;
    private Integer age;
    private String addr;

    /**
     * 为了方便测试，此处填充一个list
     * @return
     */
    public static List<User> getUserList(){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUserName("张三");
        user.setAddr("北京市昌平区");
        user.setAge(18);
        user.setId(1L);
        list.add(user);
        User user2 = new User();
        user2.setUserName("李四");
        user2.setAddr("北京市东城区");
        user2.setAge(19);
        user2.setId(2L);
        list.add(user2);
        User user3 = new User();
        user3.setUserName("王五");
        user3.setAddr("北京市西城区");
        user3.setAge(20);
        user3.setId(3L);
        list.add(user3);
        return list;
    }
}
