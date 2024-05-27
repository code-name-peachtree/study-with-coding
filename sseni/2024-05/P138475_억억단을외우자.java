package com.example.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class P138475_억억단을외우자 {
    public static int[] solution(int e, int[] starts) {
        Point[] dp = new Point[e + 1];
        for (int i = 0; i <= e; i++) {
            dp[i] = new Point(i, 0);
        }

        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                dp[j].c++;
            }
        }

        // 약수의 개수가 큰 순서대로 정렬하기
        Arrays.sort(dp, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.c < o2.c) return 1;
                else if(o1.c > o2.c) return -1;
                else { // 같다면, 더 작은 숫자 반환
                    if(o1.n > o2.n) return 1;
                    else if(o1.n < o2.n) return -1;
                    else return 0;
                }
            }
        });

        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            for (int j = 0; j <= e; j++) {
                if (starts[i] <= dp[j].n) {
                    answer[i] = dp[j].n;
                    break;
                }
            }
        }

        return answer;
    }

    static class Point {
        int n, c;

        Point(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8, new int[]{1, 3, 7})));
    }
}
