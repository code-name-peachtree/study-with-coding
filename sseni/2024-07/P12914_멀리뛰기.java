package com.example.algorithm;

public class P12914_멀리뛰기 {
    public static long solution(int n) {
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_234_567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }
}
