package com.cdz.sort;

import java.time.LocalDate;

public class InsertSelect {

    public static Integer[] sort(Integer[] array) {
        assert array != null : "空指针异常";
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int key = array[i];
            while (i >= 1 && key > array[i - 1]) {
                array[i] = array[i - 1];
                i = i - 1;
            }
            array[i] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Integer[] array = {6, 7, 1, 3, 5, 10, 5, 9, 13, 65, 37};
        long end = System.currentTimeMillis();
        System.out.println("排序时间:" + (start - end) + "毫秒");
        sort(array);
    }
}
