package com.cdz.search;

public class BinarySearch {

    public static Integer bynarySearch(Integer[] array, Integer searchKey, Integer min, Integer high) {
        Integer mid = (high + min) / 2;
        if (min > high) {
            System.out.println("未找到。。。。");
            return null;
        }
        if (array[mid] < searchKey.intValue()) {
            bynarySearch(array, searchKey, mid + 1, high);
        } else if (array[mid] > searchKey.intValue()) {
            bynarySearch(array, searchKey, min, mid - 1);
        } else {
            System.out.println("找到。。。。" + mid);
            return mid;
        }
        return null;
    }


    public static Integer bynarySearch(Integer[] array, Integer searchKey) {
        Integer low = 0;
        Integer high = array.length - 1;
        while (true) {
            Integer mid = (low + high) / 2;
            if (low > high) {
                break;
            }
            if (array[mid] > searchKey.intValue()) {
                high = mid - 1;
            } else if (array[mid] < searchKey) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int min = 0;
        int high = array.length - 1;
//        Integer found = bynarySearch(array, 10, 0, high);
        Integer aFound = bynarySearch(array, 8);
    }
}
