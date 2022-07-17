package com.example.design_patterns.decorator;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 7:40
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        ManService man = new ManService();
        SunService md1 = new SunService();
        Daughter md2 = new Daughter();
        md1.setPerson(man);
        md2.setPerson(md1);
        md2.eat();
    }
}
