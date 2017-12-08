package com.cdz.sort;

import java.util.Arrays;

public class OESort {
    public static void oeSort(Integer[] array) {

        boolean isOSorted = false;
        boolean isESorted = false;

        while (!isESorted || !isOSorted) {
            isOSorted = true;
            isESorted = true;
            for (int i = 0; i < array.length - 1; i = i + 2) {
                if (array[i] > array[i + 1]) {
                    isOSorted = false;
                    swap(array, i);
                }
            }
            for (int i = 1; i < array.length - 1; i = i + 2) {
                if (array[i] > array[i + 1]) {
                    swap(array, i);
                    isESorted = false;
                }
            }
        }
    }

    private static void swap(Integer[] array, int i) {
        array[i] = array[i] ^ array[i + 1];
        array[i + 1] = array[i] ^ array[i + 1];
        array[i] = array[i] ^ array[i + 1];
    }

    public static void main(String[] args) {
        Integer[] array = {1, 5, 8, 7, 6, 2, 3, 8, 4, 5};
        oeSort(array);
        Arrays.asList(array).forEach(item -> System.out.print(item + ","));
    }
}
