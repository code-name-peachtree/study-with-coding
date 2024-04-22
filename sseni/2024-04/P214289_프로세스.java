package com.example.algorithm.study;

import java.util.*;

// 중요도가 클수록 더 높은 우선순위
// 내림차순인 우선순위 큐
public class P214289_프로세스 {
    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : priorities) {
            pq.add(i);
        }

        int answer = 1;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (!pq.isEmpty() && pq.peek() == priorities[i]) {
                    if (location == i) return answer;

                    pq.poll();
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
