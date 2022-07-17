package com.example.design_patterns.singleton;

/**
 * @ClassName TestSingleton
 * @Description TODO 以下是一个单例类使用的例子，以懒汉式为例，这里为了保证线程安全，使用了双重检查锁定的方式
 * @Author Summer_DM
 * @Date 2022/7/17 7:57
 * @Version 1.0
 */
public class TestSingleton {
    String name = null;
    private TestSingleton() {
    }
    private static volatile TestSingleton instance = null;
    public static TestSingleton getInstance() {
        if (instance == null) {
            synchronized (TestSingleton.class) {
                if (instance == null) {
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void printInfo() {
        System.out.println("the name is " + name);
    }


    public static void main(String[] args){
        TestSingleton ts1 = TestSingleton.getInstance();
        ts1.setName("jason");
        TestSingleton ts2 = TestSingleton.getInstance();
        ts2.setName("0539");
        ts1.printInfo();
        ts2.printInfo();
        if(ts1 == ts2){
            System.out.println("创建的是同一个实例");
        }else{
            System.out.println("创建的不是同一个实例");
        }
    }
}
