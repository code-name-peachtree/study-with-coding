package com.example.algorithm;

public class P140107_점찍기 {
    public static long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            answer += ((int) Math.sqrt((long) d * d - (long) i * i)) / k + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }
}
