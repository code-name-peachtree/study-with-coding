package com.example.algorithm;

// 테두리 체크하기 위한 올림 함수 ceil, 내림 함수 floor
public class P181187_두원사이의정수쌍 {
    public static long solution(int r1, int r2) {
        long answer = 0;

        for (long i = 1; i <= r2; i++) {
            long x = (int) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i));
            long y = (int) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i));
            answer += (y - x + 1);
        }

        return  answer * 4;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }
}
