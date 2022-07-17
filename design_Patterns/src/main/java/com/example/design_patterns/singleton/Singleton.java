package com.example.design_patterns.singleton;

/**
 * @ClassName Singleton
 * @Description TODO  懒汉式  懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton实例
 * @Author Summer_DM
 * @Date 2022/7/17 7:48
 * @Version 1.0
 */
public class Singleton {
    private Singleton() {}
    private static Singleton single=null;
    //静态工厂方法  此为线程不安全的
    public static Singleton getInstance1() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }
    //静态工厂方法  此为通过加锁来实现线程安全的
    public static synchronized Singleton getInstance2() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }
    //静态工厂方法  此为通过双重检查加锁来实现线程安全的
    public static Singleton getInstance3() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }
    //匿名内部类方法  此为通过创建一个匿名内部类来实现线程安全的
//    public class Singleton4 {
//        private static class LazyHolder {
//            private static final Singleton INSTANCE = new Singleton();
//        }
//        private Singleton (){}
//        public static final Singleton getInstance() {
//            return LazyHolder.INSTANCE;
//        }
//    }
}
