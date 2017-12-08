package com.cdz.jn;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println(111));
        t.start();
    }
}
