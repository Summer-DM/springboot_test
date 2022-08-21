package com.example.desensitizedutil.model;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/8/14 9:51
 * @Version 1.0
 */
@Data
public class User {
    /**
     * name
     */
    private String name;

    /**
     * idCard
     */
    private String idCard;

    /**
     * cardNo
     */
    private String cardNo;

    /**
     * mobile
     */
    private String mobile;

    /**
     * tel
     */
    private String tel;

    /**
     * password
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * address
     */
    private String address;

    /**
     * birth
     */
    private Date birth;
    /**
     * job
     */
    private Job job;

}
