package com.cdz.link;

public class Node {
    private Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
