package com.example.algorithm.study;

// 절반보다 크면, 더해서 큰 값을 만든다
// 절반보다 작으면, 빼서 작은 값을 만든다
public class P148653_마법의엘리베이터 {
    public static int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int n = storey % 10;
            storey /= 10;

            if (n > 5) {
                answer += (10 - n);
                storey++;
            } else if (n < 5) {
                answer += n;
            } else if (storey % 10 >= 5) {
                answer += 5;
                storey++;
            } else {
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
    }
}
