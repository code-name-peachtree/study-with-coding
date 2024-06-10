package com.example.algorithm.study;

public class P250137_붕대감기 {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int now = health - attacks[0][1];

        if (now <= 0) return -1;

        for (int i = 1; i < attacks.length; i++) {
            int tmp = attacks[i][0] - attacks[i - 1][0] - 1;
            int recovery = ((int) (tmp / bandage[0])) * bandage[2];

            now += bandage[1] * tmp + recovery;

            if (now > health) now = health;

            now -= attacks[i][1];

            if (now <= 0) return -1;
        }

        return now;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
    }
}
