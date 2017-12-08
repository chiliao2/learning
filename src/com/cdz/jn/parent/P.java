package com.cdz.jn.parent;

public class P {
    public P() {
        System.out.println("父类构造器调用");
    }

    {
        System.out.println("父类初始化代码块");
    }

    static {
        System.out.println("父类静态代码块");
    }

    public int num = 1;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
