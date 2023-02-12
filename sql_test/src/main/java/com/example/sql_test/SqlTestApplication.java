package com.example.sql_test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SqlTestApplication {

    public static void main(String[] args) {
        JSONObject js = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("1");
        js.put("aa",list);
        JSONArray aa = js.getJSONArray("aa");
        List<String> strings = JSONObject.parseArray(aa.toJSONString(), String.class);
        System.out.println(strings);
        System.out.println("sdasda"+aa);
     }

}
