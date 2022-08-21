package com.example.desensitizedutil.model;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Job
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/8/14 9:52
 * @Version 1.0
 */
@Data
public class Job {
    /**
     * jobName
     */
    private String jobName;

    /**
     * salary
     */
    private int salary;

    /**
     * company
     */
    private String company;

    /**
     * address
     */
    private String address;

    /**
     * tel
     */
    private String tel;

    /**
     * position
     */
    private List<String> position;


}
