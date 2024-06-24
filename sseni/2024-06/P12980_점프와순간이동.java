package com.example.algorithm;

// 짜고 보니까 앞에서 푼 비트에서 1 개수 카운트하는 함수랑 똑같잖아 ?
// 완전 럭키비키 ~
public class P12980_점프와순간이동 {
    public static int solution(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }
}
