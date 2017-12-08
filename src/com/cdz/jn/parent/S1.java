package com.cdz.jn.parent;

public class S1 extends P {
    static {
        System.out.println("s1 静态代码块");
    }

    {
        System.out.println("s1 代码块");
    }

    public S1() {
        System.out.println("s1 构造器");
    }
}
