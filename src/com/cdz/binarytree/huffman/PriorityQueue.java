package com.cdz.binarytree.huffman;

import java.util.HashMap;
import java.util.Map;

public class PriorityQueue {
    private Node root;

    public void insert(com.cdz.binarytree.huffman.Node node) {
        Node pNode = new Node(node);
        if (root == null) {
            root = pNode;
            return;
        }
        Node current = root;
        Node parent = current;
        while (current != null) {
            if (current.node.frequence >= pNode.node.frequence) {
                pNode.next = current;
                if (current == root) {
                    root = pNode;
                } else {
                    parent.next = pNode;
                }
                return;
            }
            parent = current;
            current = current.next;
        }
        parent.next = pNode;
    }

    public com.cdz.binarytree.huffman.Node pop() {
        if (root == null) {
            return null;
        }
        Node top = root;
        root = root.next;
        return top.node;
    }

    public Node createHuffmanNode() {
        if (root != null && root.next == null) {
            return root;
        }
        com.cdz.binarytree.huffman.Node node1 = pop();
        com.cdz.binarytree.huffman.Node node2 = pop();
        insert(new com.cdz.binarytree.huffman.Node(node1, node2, node1.frequence + node2.frequence));
        return createHuffmanNode();
    }

    public Map<Character, String> createHuffmanTable() {
        Map<Character, String> table = new HashMap<>();
        createHuffmanTable(root.node, "", table);
        return table;
    }

    private void createHuffmanTable(com.cdz.binarytree.huffman.Node node, String str, Map<Character, String> table) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            table.put(node.content, str);
            table.put(node.content, str);
        }
        createHuffmanTable(node.left, str + "0", table);
        createHuffmanTable(node.right, str + "1", table);
    }

    private class Node {
        private com.cdz.binarytree.huffman.Node node;
        private Node next;

        public Node(com.cdz.binarytree.huffman.Node node) {
            this.node = node;
        }
    }

}
