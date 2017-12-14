package com.cdz.binarytree.huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Throwable {

        HuffmanApp huffmanApp = new HuffmanApp();
        File file = new File("original.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PrintWriter writer = new PrintWriter("a.cps");
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        writer.write(huffmanApp.encode(sb.toString()));
        reader.close();
        writer.close();

        char c = '3';
        System.out.println(Integer.valueOf(c));
    }
}
