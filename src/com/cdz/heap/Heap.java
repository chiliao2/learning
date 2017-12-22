package com.cdz.heap;

import java.util.Arrays;

public class Heap {
    private Integer[] array;
    private Integer items = 0;

    public Heap(Integer length) {
        array = new Integer[length];
    }

    public boolean isFull() {
        return items == array.length;
    }


    public void insert(Integer key) {
        if (isFull()) {
            throw new RuntimeException("can not insert data,heap is full");
        }
        array[items++] = key;
        int index = items - 1;
        triggerup(index);
    }

    private void triggerup(Integer index) {
        Integer temp = array[index];
        while (index > 0) {
            Integer parent = (index - 1) / 2;
            if (temp > array[parent]) {
                array[index] = array[parent];
            } else {
                break;
            }
            index = parent;
        }
        array[index] = temp;
    }

    public Integer remvoeFirst() {
        Integer first = array[0];
        array[0] = array[--items];
        array[items] = null;
        triggerdown(0);
        return first;
    }

    private void triggerdown(Integer index) {
        Integer leftChild = 0;
        Integer rightChild = 0;
        Integer largeChild = 0;
        Integer temp = array[index];
        while (index < items / 2) {
            leftChild = 2 * index + 1;
            rightChild = leftChild + 1;
            if (rightChild < items && array[leftChild] < array[rightChild]) {
                largeChild = rightChild;
            } else {
                largeChild = leftChild;
            }
            if (temp >= array[largeChild]) {
                break;
            }
            array[index] = array[largeChild];
            index = largeChild;
        }
        array[index] = temp;
    }


    public boolean change(Integer index, Integer newVal) {
        if (index < 0 || index > items) {
            return false;
        }
        Integer old = array[index];
        array[index] = newVal;
        if (old < newVal) {
            triggerup(index);
        } else {
            triggerdown(index);
        }
        return true;
    }

    /**
     * 堆排序
     *
     * @param array
     */
    public void heapSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
        for (int i = 0; i < this.array.length; i++) {
            array[i] = remvoeFirst();
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(21);
        heap.insert(32);
        heap.insert(45);
        heap.insert(25);
        heap.insert(24);
        heap.insert(31);
        heap.insert(55);
        heap.change(6, 99);
//        heap.remvoeFirst();
//        heap.remvoeFirst();

//        Integer[] array = {2, 8, 6, 4, 1, 5, 9, 7, 3, 44};
//        Arrays.asList(array).forEach(i -> System.out.print(i + ","));
//        System.out.println();
//        heap.heapSort(array);
//        Arrays.asList(array).forEach(i -> System.out.print(i + ","));
    }
}
