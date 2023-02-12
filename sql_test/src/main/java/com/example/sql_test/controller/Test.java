package com.example.sql_test.controller;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/8/31 20:44
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int nub = getNub(4);
        System.out.println("的撒大声地\n"+ nub);

    }

    public static int getNub(int s){
        int num = 10;
        try {
             get(s, num);
        }catch (Exception e){
            System.out.println("报错了\n");
        }finally {
            System.out.println("dasdasdasdasdasdasd\n");
        }
        System.out.println("你猜我猜㢀");
        return 0;
    }
    public static int get(int s,int b){
        try {
           int v = s/0;
           return v;
        }catch (Exception e){
            System.out.println("sdasd报错了");
        }
        return 1;
    }
}
