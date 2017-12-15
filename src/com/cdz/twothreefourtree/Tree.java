package com.cdz.twothreefourtree;

public class Tree {
    private Node root = new Node();


    public Node getNextChild(Node theNode, Integer theValue) {
        int n = theNode.getItemsNum();
        int i;
        for (i = 0; i < n; i++) {
            if (theValue < theNode.getData(i)) {
                return theNode.getChild(i);
            }
        }
        return theNode.getChild(i);
    }

    public Integer find(Integer key) {
        Node current = root;
        int childNum = -1;
        while (current != null) {
            if ((childNum = current.findItem(key)) != -1) {
                return childNum;
            } else if (current.isLeaf()) {
                return -1;
            } else {
                current = getNextChild(current, key);
            }
        }
        return childNum;
    }

    public void insert(Integer value) {
        Node current = root;
        while (true) {
            if (current.isFull()) {
                split(current);
                current = current.getParent();
                current = getNextChild(current, value);
            } else if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(current, value);
            }
        }
        current.insertItem(value);
    }

    private void split(Node current) {
        int itemc, itemb;
        Node parent, child2, child3;
        int itemIndex;
        itemc = current.removeItem();
        itemb = current.removeItem();
        child2 = current.disconnectChild(2);
        child3 = current.disconnectChild(3);
        Node newRight = new Node();
        if (current == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, current);
        } else {
            parent = current.parent;
        }
        itemIndex = parent.insertItem(itemb);
        int item = parent.getItemsNum();
        for (int i = item - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }
        newRight.insertItem(itemc);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
        parent.connectChild(itemIndex + 1, newRight);
    }

    public void displayTree() {
        recDisplayNode(root, 0, 0);
    }

    private void recDisplayNode(Node node, Integer level, int childNum) {
        System.out.print("level=" + level + "childNum=" + childNum + " ");
        node.displayNode();
        int n = node.getItemsNum() + 1;
        for (int i = 0; i < n; i++) {
            Node next = node.getChild(i);
            if (next != null) {
                recDisplayNode(next, level + 1, i);
            } else {
                return;
            }
        }
    }
}
