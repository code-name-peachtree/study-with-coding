package com.example.algorithm;

// Integer.bitCount() 메서드 사용해도 된다
public class P12911_다음큰숫자 {
    public static int solution(int n) {
        int answer = 0;

        int cnt = countOne(n);
        // int cnt = Integer.bitCount(n);
        while (true) {
            if (cnt == countOne(++n)) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    static int countOne(int n) {
        int answer = 1;

        while (n > 1) {
            if (n % 2 == 1) answer++;
            n /= 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }
}
