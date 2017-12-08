package com.cdz;

public class App {
    public static void main(String[] args) {
        String str = "Iteration code size (new code size modification) (KLOC)".trim();
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split(" ");
        sb.append(strs[0].toLowerCase());
        for (int i = 1; i < strs.length; i++) {
            sb.append((strs[i].charAt(0) + "").toUpperCase());
            sb.append(strs[i].substring(1, strs[i].length()));
        }
        System.out.println(sb.toString());
    }
}
