package com.cdz.binarytree.huffman;

import com.cdz.stack.PriorityQ;

import java.util.HashMap;
import java.util.Map;

public class HuffmanApp {

    private Map<Character, Integer> frequences = new HashMap<>();
    private Map<Character, String> table;
    PriorityQueue q = new PriorityQueue();

    public String encode(String str) {
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (frequences.get(c) == null) {
                frequences.put(c, 1);
            } else {
                frequences.put(c, frequences.get(c) + 1);
            }
        }

        for (Character c : frequences.keySet()) {
            q.insert(new Node(c, frequences.get(c)));
        }
        q.createHuffmanNode();
        table = q.createHuffmanTable();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            String code = table.get(c);
            sb.append(code);
        }
        return sb.toString();
    }

    public void decode(String str) {
        Map<String, Character> map = new HashMap<>();
        for (Character c : table.keySet()) {
            map.put(table.get(c), c);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < str.length(); i++) {
            sb.append(str.charAt(i));
            Character decode = map.get(sb.toString());
            if (decode == null) {
                continue;
            } else {
                System.out.print(decode);
                break;
            }
        }
        if (str.length() - 1 == i) {
            return;
        }
        str = str.substring(i + 1, str.length());
        decode(str);
    }
}
