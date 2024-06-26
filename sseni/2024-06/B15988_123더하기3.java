package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// long 타입 때문에 5번 틀림 ㅜㅡㅠ
public class B15988_123더하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] testArr = new int[t];
        for (int i = 0; i < t; i++) {
            testArr[i] = Integer.parseInt(br.readLine());
        }

        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1_000_001; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(dp[testArr[i]]);
        }
    }
}
