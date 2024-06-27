package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4883_삼각그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = 1_000_001;
                }
            }

            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][1] + arr[0][2];

            dp[1][0] = dp[0][1] + arr[1][0];
            dp[1][1] =  min(dp[0][1], min(dp[0][2], dp[1][0])) + arr[1][1];
            dp[1][2] =  min(dp[0][1], min(dp[1][1], dp[0][2])) + arr[1][2];

            for (int i = 2; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = arr[i][j];

                    if (j == 0) dp[i][j] += min(dp[i - 1][j], dp[i - 1][j + 1]);
                    if (j == 1) dp[i][j] += min(dp[i - 1][j - 1], min(dp[i - 1][j],
                            min(dp[i - 1][j + 1], dp[i][j - 1])));
                    if (j == 2) dp[i][j] += min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1]));
                }
            }

            sb.append(T++).append(". ").append(dp[n - 1][1]).append("\n");
        }

        System.out.println(sb);
    }

    static int min(int a, int b) {
        if (a < b) return a;
        else return b;
    }
}
