package com.cdz.sort;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class PacketProblem {
    public static void packetWeight(Integer total, Integer[] array) {
        int len = array.length;
        Integer sum = 0;
        for (int i = 0; i < len; i++) {
            sum += array[i];
        }
        if (total > sum) {
            System.out.println("无法完成背包问题");
        }
        for (int i = 0; i < len; i++) {
            String str = total + ",";
            recursePacket(total, i, array.length, array, str);
        }
    }

    static void recursePacket(Integer remain, Integer index, Integer len, Integer[] array, String str) {
        for (; index < len; index++) {
            str += array[index] + ",";
            System.out.println(str);
            remain = remain - array[index];
            if (remain == 0) {
                System.out.println("找到了:" + str);
                return;
            }
            if (remain < 0) {
                return;
            }
            recursePacket(remain, ++index, len, array, str);
        }
    }

    public static void main(String[] args) {
        packetWeight(10, new Integer[]{11, 8, 7, 6, 1, 1, 1});
    }
}
