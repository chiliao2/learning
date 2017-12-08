package com.cdz.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RadixSort {

    private Map<String, LinkedList> map = new HashMap<>();

    public RadixSort() {
        for (int i = 0; i < 10; i++) {
            LinkedList list = new LinkedList();
            map.put("list" + i, list);
        }
    }

    /**
     * @param array 带排序的数组
     * @param radix 基数
     */
    public void radixSort(Integer[] array, Integer radix) {
        for (int i = 0; i < array.length; i++) {
            Integer remainder = array[i] % radix;
            for (int j = 0; j < 10; j++) {
                map.get("list" + j).addLast(array[i]);
            }
        }
    }
}
