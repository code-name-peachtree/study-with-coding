package com.example.algorithm;

public class P148652_유사칸토어비트열 {
    public static int solution(int n, long l, long r) {
        int answer = 0;

        for (long val = l; val <= r; val++) {
            answer += func(n, val - 1);
        }

        return answer;
    }

    static int func(int n, long l) {
        if (n == 0 || l == 0)
            return 1;
        if (l % 5 == 2)
            return 0;
        return func(n - 1, l / 5);
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 17));
    }
}
