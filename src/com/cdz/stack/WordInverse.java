package com.cdz.stack;

public class WordInverse {

    private char[] chars;

    private Integer top = -1;

    private void push(char c) {
        chars[++top] = c;
    }

    private char pop() {
        return chars[top--];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public String wordInverse(String in) {
        chars = new char[in.length()];
        for (int i = 0; i < in.length(); i++) {
            push(in.charAt(i));
        }
        StringBuilder out = new StringBuilder();
        while (!isEmpty()) {
            out.append(pop());
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String inverse = new WordInverse().wordInverse("i am a smart man");
        System.out.println(inverse);
    }

}
