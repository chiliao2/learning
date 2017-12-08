package com.cdz.jn.parent;

public class S2 extends P {

    private static int nums = 1;
    private B b = new B();

    static {
        System.out.println("s2 静态代码块");
    }

    {
        System.out.println("s2 代码块");
    }

    public S2() {
        System.out.println("s2 构造器");
    }

    public static int getNums() {
        return nums;
    }

    public static void setNums(int nums) {
        S2.nums = nums;
    }
}
