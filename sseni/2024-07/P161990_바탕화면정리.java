package com.example.algorithm;

import java.util.Arrays;

public class P161990_바탕화면정리 {
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4]; // min, max
        answer[0] = 51;
        answer[1] = 51;

        for (int i = 0; i < wallpaper.length; i++) {
            char[] desktop = wallpaper[i].toCharArray();

            for (int j = 0; j < desktop.length; j++) {
                if ((desktop[j]) == '#') {
                    if (i < answer[0]) answer[0] = i;
                    if (j < answer[1]) answer[1] = j;

                    if (i + 1 > answer[2]) answer[2] = i + 1;
                    if (j + 1 > answer[3]) answer[3] = j + 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{".#...", "..#..", "...#."})));
    }
}
