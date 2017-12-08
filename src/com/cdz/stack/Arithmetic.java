package com.cdz.stack;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Arithmetic {

    private boolean leagalArithmetic(String formula) {
        BlockingDeque<Character> deque = new LinkedBlockingDeque();
        int len = formula.length();
        for (int i = 0; i < len; i++) {
            char c = formula.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    deque.addFirst(c);
                    break;
                case ')':
                    if (deque.isEmpty() || deque.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (deque.isEmpty() || deque.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (deque.isEmpty() || deque.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        if (!deque.isEmpty()) {
            return false;
        }
        return true;
    }

    private String suffixEsxpression(String suffixEsxpression) {
        if (!leagalArithmetic(suffixEsxpression)) {
            throw new IllegalArgumentException("传入的表达式不正确");
        }
        StringBuilder sb = new StringBuilder();
        LinkedBlockingDeque<Character> symbol = new LinkedBlockingDeque();
        int len = suffixEsxpression.length();
        for (int i = 0; i < len; i++) {
            char c = suffixEsxpression.charAt(i);
            if (symbol.isEmpty() || c == '(') {
                symbol.push(c);
            } else {
                switch (c) {
                    case ')':
                        char c1;
                        while (!symbol.isEmpty()) {
                            if ((c1 = symbol.pop()) != '(') {
                                sb.append(c1);
                            } else {
                                break;
                            }
                        }
                        break;
                    case '+':
                    case '-':
                        char popc = symbol.pop();
                        if (popc == '(') {
                            symbol.push(popc);
                            symbol.push(c);
                            break;
                        }
                        sb.append(popc);
                        symbol.push(c);
                        break;
                    case '*':
                    case '/':
                        char popC = symbol.pop();
                        if (popC == '+' || popC == '-' || popC == '(') {
                            symbol.push(popC);
                            symbol.push(c);
                        } else {
                            sb.append(popC);
                            symbol.push(c);
                        }
                        break;
                    default:
                        sb.append(c);
                }
            }
        }
        while (!symbol.isEmpty()) {
            sb.append(symbol.pop());
        }
        return sb.toString();
    }

    public double calculateInfixExpression(String infixExpression) {
        LinkedBlockingDeque<Integer> operands = new LinkedBlockingDeque<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);
            switch (c) {
                case '+':
                    operands.push(operands.pop() + operands.pop());
                    break;
                case '-':
                    Integer minus = operands.pop();
                    Integer fMinus = operands.pop();
                    operands.push(fMinus - minus);
                    break;
                case '*':
                    operands.push(operands.pop() * operands.pop());
                    break;
                case '/':
                    Integer dividends = operands.pop();
                    Integer divisor = operands.pop();
                    operands.push(divisor / dividends);
                    break;
                default:
                    operands.push(c - '0');
                    break;
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        String str = "(2+2+3*(2+(2+3)))";
        String expression = arithmetic.suffixEsxpression(str);
        System.out.println("表达式:" + expression);
        double result = arithmetic.calculateInfixExpression(expression);
        System.out.println(result);
    }
}
