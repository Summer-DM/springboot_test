package com.example.sql_test;

import com.example.sql_test.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/8/21 9:00
 * @Version 1.0
 */

@Mapper
@Component("UserMapper")
public interface UserMapper {
    boolean insertUser(User user);
}
