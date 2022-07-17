package com.example.design_patterns.decorator;

/**
 * @author Summer_DM
 */
public class Daughter extends WomanService {
    @Override
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("DaughterB类");
    }
}
