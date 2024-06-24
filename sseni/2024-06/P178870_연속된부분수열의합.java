package com.example.algorithm;

import java.util.Arrays;

public class P178870_연속된부분수열의합 {
    public static int[] solution(int[] sequence, int k) {
        int n = sequence.length;

        int start = 0, end = n, sum = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && sum < k) {
                sum += sequence[j++];
            }

            if (sum == k) {
                if (end - start > j - i - 1) {
                    start = i;
                    end = j - 1;
                }
            }

            sum -= sequence[i];
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }
}
