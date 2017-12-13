package com.cdz.binarytree;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(30);
        tree.insert(13);
        tree.insert(34);
        tree.insert(56);
        tree.insert(32);
        tree.insert(15);
        tree.insert(57);
        tree.insert(21);
        tree.insert(48);
        tree.insert(51);
//        tree.find(21).displayNode();
//        tree.displayTree();
        Node delete = tree.delete(34);
        tree.displayTree();

    }
}
