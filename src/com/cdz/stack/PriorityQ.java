package com.cdz.stack;

public class PriorityQ {

    private int maxSize;
    private long[] array;
    private int nItems;

    public PriorityQ(int size) {
        this.maxSize = size;
        array = new long[size];
        nItems = 0;
    }

    public void insert(long data) {
        int n;
        if (nItems == 0) {
            array[nItems++] = data;
        } else {
            for (n = nItems - 1; n >= 0; n--) {
                if (data > array[n]) {
                    array[n + 1] = array[n];
                } else {
                    break;
                }
            }
            array[n + 1] = data;
            nItems++;
        }
    }

    public long pop() {
        return array[--nItems];
    }

    public static void main(String[] args) {
        PriorityQ q = new PriorityQ(10);
        q.insert(3);
        q.insert(6);
        q.insert(1);
        q.insert(60);
        System.out.println(q.pop());
    }
}
