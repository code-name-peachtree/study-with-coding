package com.example.algorithm.study;

import java.util.Arrays;

public class P136797_숫자타자대회 {
    static int length;
    static String number;
    static int[][][] dp;  // [index][left][right]
    static int[][] cost = {  // [시작][끝]
            { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
            { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
            { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
            { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
            { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
            { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
            { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
            { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
            { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
            { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };

    public static int solution(String numbers) {
        number = numbers;
        length = numbers.length();
        dp = new int[length + 1][10][10];

        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return func(0, 4, 6);
    }

    static int func(int i, int left, int right) {
        // 기저
        if(i == length) return 0;
        if(dp[i][left][right] != -1) return dp[i][left][right];

        int n = number.charAt(i) - '0';
        int result = Integer.MAX_VALUE;

        // 왼 이동
        if (n != right) result = Math.min(func(i + 1, n, right) + cost[left][n], result);
        // 오 이동
        if(n != left) result = Math.min(func(i + 1, left, n) + cost[right][n], result);

        return dp[i][left][right] = result;
    }

    public static void main(String[] args) {
        System.out.println(solution("1756"));
        System.out.println(solution("5123"));
    }
}
