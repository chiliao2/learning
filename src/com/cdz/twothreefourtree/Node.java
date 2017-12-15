package com.cdz.twothreefourtree;

public class Node {

    public Node parent;
    private Integer maxLength = 4;
    public Integer[] data = new Integer[maxLength - 1];
    public Node[] children = new Node[maxLength];
    private Integer n = 0;

    public boolean isFull() {
        return n == this.maxLength - 1;
    }

    public boolean isLeaf() {
        return this.children[0] == null;
    }

    public int insertItem(Integer key) {
        n++;
        for (int i = this.maxLength - 2; i >= 0; i--) {
            if (data[i] == null) {
                continue;
            } else {
                if (key < data[i]) {
                    data[i + 1] = data[i];
                } else {
                    data[i + 1] = key;
                    return i + 1;
                }
            }
        }
        data[0] = key;
        return 0;
    }

    public int removeItem() {
        int temp = data[n - 1];
        data[n - 1] = null;
        n--;
        return temp;
    }

    public void connectChild(int childNum, Node child) {
        this.children[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node temp = this.children[childNum];
        this.children[childNum] = null;
        return temp;
    }

    public Node getChild(int childNum) {
        return this.children[childNum];
    }

    public int getItemsNum() {
        return this.n;
    }

    public Integer getData(int item) {
        return this.data[item];
    }

    public Node getParent() {
        return this.parent;
    }

    public int findItem(Integer key) {
        for (int i = 0; i < this.maxLength - 1; i++) {
            if (this.data[i] == null) {
                break;
            } else if (this.data[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public void displayNode() {
        for (int i = 0; i < n; i++) {
            System.out.print("/" + data[i]);
        }
        System.out.println("/");
    }
}
