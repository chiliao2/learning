package com.cdz.jdk8;

public class App {
    public static void main(String[] args) {
        String msg = "桃子";
        Monkey monkey = (s) -> System.out.println("猴子吃的是:" + msg);
        monkey.eat("香蕉");
        monkey.run();
    }
}
