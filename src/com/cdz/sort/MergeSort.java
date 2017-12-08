package com.cdz.sort;

import java.util.Random;

public class MergeSort {
    public Integer[] mergeSort(Integer[] one, Integer[] another) {
        Integer[] result = new Integer[one.length + another.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < one.length && j < another.length) {
            if (one[i] < another[j]) {
                result[k++] = one[i++];
            } else {
                result[k++] = another[j++];
            }
        }
        while (i < one.length) {
            result[k++] = one[i++];
        }
        while (j < another.length) {
            result[k++] = another[j++];
        }
        return result;
    }

    public Integer[] mergeSort(Integer[] array, Integer low, Integer mid, Integer high) {
        Integer[] temp = new Integer[high - low + 1];
        Integer i = low;
        Integer j = mid + 1;
        Integer k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            array[low + m] = temp[m];
        }
        return array;
    }

    public void recurseSort(Integer[] array, Integer low, Integer high) {
        if (low < high) {
            Integer mid = (low + high) / 2;
            recurseSort(array, low, mid);
            recurseSort(array, (mid + 1), high);
            mergeSort(array, low, mid, high);
        }
    }


    public static void main(String[] args) {
        Random random = new Random();
        int len = 500000;
        Integer[] array = new Integer[len];
        for (int i = 0; i < len; i++) {
            array[i] = random.nextInt(1000000);
        }
        long t1 = System.currentTimeMillis();
        new MergeSort().recurseSort(array, 0, array.length - 1);
        long t2 = System.currentTimeMillis();
        System.out.println("耗时：" + (t2 - t1));
    }

}
