package com.cdz.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(Integer[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
            Arrays.asList(array).forEach(item -> System.out.print(item + ","));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 5, 6, 8, 4, 6, 3, 2, 8};
        bubbleSort(array);
    }
}
