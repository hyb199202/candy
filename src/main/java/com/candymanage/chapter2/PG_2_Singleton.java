package com.candymanage.chapter2;

public class PG_2_Singleton {
    public static void main(String[] args) {
        //Singleton1 singleton1 = Singleton1;
        Singleton7 singleton7 = Singleton7.instance;
        singleton7.setAttribute("111");
        System.out.println(singleton7.getAttribute());
    }


    //版本一：饿汉式
    //特点：线程安全；在类初始化执行到静态属性时就分配了资源，有资源浪费问题；

    static class Singleton1 {
        //或者将私有静态final成员设为公有成员，可省去getInstance公有函数
        private final Singleton1 instance = new Singleton1();

        private Singleton1() {
        }

        public Singleton1 getInstance() {
            return instance;
        }
    }

    //版本二：懒汉式(非线程安全)
    //特点：在第一次调用获取实例方法时分配内存，实现了懒加载；非线程安全；
    class Singleton2 {
        private Singleton2 instance = null;

        private Singleton2() {
        }

        public Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }
//版本七：通过枚举实现
//一个完美的单例需要做到：单例，懒加载，线程安全，防止反序列化产生新对象，防止反射攻击
//而枚举的特性保证了以上除了懒加载以外的所有要求，而且实现代码及其简单
//

    enum Singleton7 {
        instance;
        private String attribute;

        void setAttribute(String attribute) {
            this.attribute = attribute;
        }

        String getAttribute() {
            return this.attribute;
        }
    }

}
