package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2004_조합0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long f = five(n) - five(m) - five(n - m);
        long t = two(n) - two(m) - two(n - m);

        if (m == 0) System.out.println(0);
        else System.out.println(Math.min(f, t));
    }

    static long five(long n) {
        long answer = 0;
        for (long i = 5; i <= n; i *= 5) {
            answer += n / i;
        }

        return answer;
    }

    static long two(long n) {
        long answer = 0;
        for (long i = 2; i <= n; i *= 2) {
            answer += n / i;
        }

        return answer;
    }
}
