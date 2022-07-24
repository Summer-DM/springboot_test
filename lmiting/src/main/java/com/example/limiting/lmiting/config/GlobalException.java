package com.example.limiting.lmiting.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalException
 * @Description TODO  全局异常处理器
 * @Author Summer_DM
 * @Date 2022/7/24 17:32
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ServiceException.class)
    public Map<String,Object> serviceException(ServiceException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 500);
        map.put("message", e.getMessage());
        return map;
    }
}