package com.cdz.recurse;

public class TowersApp {

    public static void main(String[] args) {
        hani(5, 'A', 'B', 'C');
    }

    public static void hani(int nDisks, char from, char inter, char to) {
        if (nDisks == 1) {
            System.out.println("盘子" + nDisks + ":" + from + "-->" + to);
        } else {
            hani(nDisks - 1, from, to, inter);
            System.out.println("盘子" + nDisks + ":" + from + "-->" + to);
            hani(nDisks - 1, inter, from, to);
        }
    }

}
