package com.example.algorithm;

import java.util.Arrays;

public class P43238_입국심사 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1, right = (long) times[times.length - 1] * n;  // 최선, 최악의 경우

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int t : times){
                sum += mid / t;  // 심사관마다 심사할 수 있는 사람 수의 합
            }

            if (sum < n) {
                left = mid + 1; // 심사하는 사람 수가 적을 때 시간을 늘려야 함
            }
            else {  // 심사하는 사람의 수가 더 많거나 같으므로 시간을 줄일 수 있음
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }
}
