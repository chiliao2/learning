package com.cdz.twothreefourtree;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(30);
        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(70);
        tree.insert(80);
        tree.insert(20);
        tree.insert(68);
        tree.insert(14);
        tree.insert(25);
        tree.insert(31);
        tree.insert(32);
        tree.insert(33);
        tree.insert(34);
        tree.insert(35);
        tree.insert(36);
        tree.insert(37);
        tree.insert(38);
        tree.insert(39);
        tree.displayTree();
        System.out.println(tree.find(80));


    }
}
