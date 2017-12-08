package com.cdz.link;

public class LinkNode {

    private Node first;
    private Node last;

    public void insertFirst(Node newNode) {
        if (last == null) {
            this.last = newNode;
        }
        newNode.next = this.first;
        first = newNode;
    }

    public void insertLast(Node newNode) {
        if (first == null) {
            first = newNode;
        }
        this.last.next = newNode;
        this.last = newNode;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
    }

    public Node find(Object key) {

        Node temp = first;
        if (temp == null) {
            return null;
        }
        while (temp != null) {
            if (key.equals(temp.getData())) {
                return temp;
            }
            temp = temp.next;
        }
        return temp;

    }

    public Node delete(Object key) {
        Node parent = null;
        Node current = first;
        if (current == null) {
            System.out.println("未找到可以删除的节点");
            return null;
        }
        while (current != null) {
            if (current.getData().equals(key)) {
                parent.next = current.next;
                return current;
            } else {
                parent = current;
                current = current.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode();
        linkNode.insertFirst(new Node(3));
        linkNode.insertFirst(new Node(4));
        linkNode.insertFirst(new Node(5));
        linkNode.insertFirst(new Node(6));
        linkNode.insertFirst(new Node(7));
        linkNode.insertLast(new Node(8));
        linkNode.display();
        System.out.println(linkNode.find(3));
        System.out.println(linkNode.delete(3));
        linkNode.display();


    }
}
