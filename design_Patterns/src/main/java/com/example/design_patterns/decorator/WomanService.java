package com.example.design_patterns.decorator;

/**
 * @ClassName Woman
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 7:32
 * @Version 1.0
 */
public class WomanService implements Decorator{

    protected Decorator person;
    public void setPerson(Decorator person) {
        this.person = person;
    }
    @Override
    public void eat() {
        System.out.println("女人在吃饭！");
    }
}
