package com.cdz.sort;

import java.util.*;

/**
 * 基数排序
 */
public class RadixSort {
    private List<LinkedList<Integer>> temp = new ArrayList<>();

    public RadixSort() {
        for (int i = 0; i < 10; i++) {
            LinkedList list = new LinkedList();
            this.temp.add(i, list);
        }
    }

    /**
     * @param array 带排序的数组
     * @param radix 基数
     * @param radix 被除数
     */
    public void radixSort(Integer[] array, Integer radix, Integer divisor) {
        for (int i = 0; i < array.length; i++) {
            Integer remainder;
            if (divisor == null) {
                remainder = array[i] % radix;
            } else {
                remainder = array[i] / divisor % radix;
            }
            temp.get(remainder).addLast(array[i]);
        }
        int j = 0;
        for (int i = 0; i < temp.size(); i++) {
            LinkedList<Integer> linkedList = temp.get(i);
            while (!linkedList.isEmpty()) {
                array[j++] = linkedList.pop();
            }
        }
        if (isSorted(array)) {
            return;
        } else {
            radixSort(array, radix, divisor * 10);
        }
    }

    private boolean isSorted(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] array = {35, 123, 895, 89, 76, 34, 562, 663, 547, 258, 21, 9, 4589, 1, 6, 4, 8, 3, 5, 2, 4};
        new RadixSort().radixSort(array, 10, 1);
        Arrays.asList(array).forEach(item -> System.out.print(item + ","));
    }

}
