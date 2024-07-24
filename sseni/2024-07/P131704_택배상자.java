package com.example.algorithm;

import java.util.Stack;

public class P131704_택배상자 {
    public static int solution(int[] order) {
        int answer = 0, n = order.length;

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (order[idx] == i) {
                idx++;
                answer++;

                while (stack.size() != 0) {
                    if (stack.peek() == order[idx]) {
                        stack.pop();
                        idx++;
                        answer++;
                    } else break;
                }
            } else {
                stack.push(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
    }
}
