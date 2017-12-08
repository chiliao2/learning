package com.cdz.sort;

public class PowerApp {
    public static Integer power(Integer x, Integer y) {
        if (y == 1) {
            return x;
        }
        if (y % 2 == 1 && y > 1) {
            return x * power(x * x, y / 2);
        }
        return power(x * x, y / 2);
    }

    public static void main(String[] args) {
        System.out.println(power(3, 15));
    }
}
