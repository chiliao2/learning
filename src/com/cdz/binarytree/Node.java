package com.cdz.binarytree;

public class Node {
    public Integer data;
    public Node left;
    public Node right;

    public boolean isDeleted = true;

    public Node(Integer data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println(data);
    }
}
