package com.cdz.jn;

public class App {
    public static void main(String[] args) {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;
        System.out.println(knapsack(val, wt, W));
    }

    public static int knapsack(int val[], int wt[], int W) {
        int N = wt.length;
        int[][] V = new int[N + 1][W + 1];
        for (int item = 1; item <= N; item++) {
            for (int weight = 1; weight <= W; weight++) {
                if (wt[item - 1] <= weight) {
                    V[item][weight] = Math.max(val[item - 1] + V[item - 1][weight - wt[item - 1]], V[item - 1][weight]);
                } else {
                    V[item][weight] = V[item - 1][weight];
                }
            }
        }
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return V[N][W];
    }
}