package com.cdz.jdk8;

@FunctionalInterface
public interface Monkey {

    void eat(String fruit);

    default void run() {
        System.out.println("猴子用脚跑");
    }

}
