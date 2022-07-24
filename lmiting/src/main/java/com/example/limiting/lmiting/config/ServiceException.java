package com.example.limiting.lmiting.config;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName ServiceException
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/24 17:33
 * @Version 1.0
 */
@Data
@ToString
public class ServiceException extends RuntimeException {
    private String message;
    private Integer code;

    public ServiceException(String message){
        this.code = 1;
        this.message = message;
    }
}
