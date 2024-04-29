package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12852_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Value[] dp = new Value[n + 1];
        dp[1] = new Value(0, "1");

        for (int i = 2; i <= n; i++) {
            int cnt = Integer.MAX_VALUE;
            int before = 0;

            if (i % 3 == 0) {
                cnt = dp[i / 3].n;
                before = i / 3;
            }

            if (i % 2 == 0) {
                if (cnt > dp[i / 2].n) {
                    cnt = dp[i / 2].n;
                    before = i / 2;
                }
            }

            if (cnt > dp[i - 1].n) {
                before = i - 1;
            }

            dp[i] = new Value(dp[before].n + 1, i + " " + dp[before].s);
        }

        System.out.println(dp[n].n);
        System.out.println(dp[n].s);
    }

    static class Value {
        int n;
        String s;

        Value(int n, String s) {
            this.n = n;
            this.s = s;
        }
    }
}
