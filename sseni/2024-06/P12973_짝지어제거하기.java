package com.example.algorithm;

import java.util.Stack;

public class P12973_짝지어제거하기 {
    public static int solution(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if(stack.peek() == c) stack.pop();
                else stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
}
