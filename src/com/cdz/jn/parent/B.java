package com.cdz.jn.parent;

public class B {

    static {
        System.out.println("B 静态代码块");
    }

    {
        System.out.println("B 初始化代码块");
    }

    public B() {
        System.out.println("B 构造器");
    }
}
