package com.cdz.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public Integer partition(Integer[] array, Integer left, Integer pivot, Integer right) {
        Integer leftPtr = left - 1;
        Integer rightPtr = right;
        while (true) {
            while (leftPtr < rightPtr && array[++leftPtr] > pivot) ;
            while (rightPtr > leftPtr && array[--rightPtr] < pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            }
            swap(array, rightPtr, leftPtr);
        }
        swap(array, right, leftPtr);
        return leftPtr;
    }

    private void swap(Integer[] array, Integer right, Integer leftPtr) {
        Integer temp = array[leftPtr];
        array[leftPtr] = array[right];
        array[right] = temp;
    }

    public void quickSort(Integer[] array, Integer left, Integer right) {
        if (right > left) {
            Integer pivot = array[right];
            Integer partition = partition(array, left, pivot, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {12, 57, 45, 63, 25, 87, 95, 41, 25, 88};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1);
        Arrays.asList(array).forEach(item -> System.out.print(item + ","));
    }
}
