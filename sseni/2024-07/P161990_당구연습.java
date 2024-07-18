package com.example.algorithm;

import java.util.Arrays;

public class P161990_당구연습 {
    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int now = 0;
            int result = Integer.MAX_VALUE;

            if (!(startY == targetY && startX >= targetX)) {
                now = distance(startX, startY, targetX * (-1), targetY);
                result = Math.min(now, result);
            }

            if (!(startY == targetY && startX <= targetX)) {
                now = distance(startX, startY, m + (m - targetX), targetY);
                result = Math.min(now, result);
            }

            if (!(startX == targetX && startY <= targetY)) {
                now = distance(startX, startY, targetX, n + (n - targetY));
                result = Math.min(now, result);
            }

            if (!(startX == targetX && startY >= targetY)) {
                now = distance(startX, startY, targetX, targetY * (-1));
                result = Math.min(now, result);
            }

            answer[i] = result;
        }

        return answer;
    }

    public static int distance(int sx, int sy, int tx, int ty) {
        return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10,10,3,7, new int[][]{{7,7},{2,7},{7,3}})));
    }
}
