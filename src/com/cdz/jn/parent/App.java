package com.cdz.jn.parent;

public class App {
    public static void main(String[] args) {
        S1 s1 = new S1();
        S2 s2 = new S2();
        S2 s21 = new S2();
        s21.setNums(999);
        System.out.println(s2.getNums());
    }
}
