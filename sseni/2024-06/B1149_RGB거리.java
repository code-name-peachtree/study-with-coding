package com.example.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(strArray[j]);
            }
        }

        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());
    }
}
