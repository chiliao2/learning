package com.cdz.binarytree.huffman;

public class Node {
    public char content;
    public Integer frequence;
    public Node left;
    public Node right;

    public Node(char content, Integer frequence) {
        this.content = content;
        this.frequence = frequence;
    }

    public Node(Node left, Node right, Integer frequence) {
        this.left = left;
        this.right = right;
        this.frequence = frequence;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("content=").append(content);
        sb.append(", frequence=").append(frequence);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
