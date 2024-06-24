package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P172927_광물캐기 {
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] arr = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        List<Mineral> list = new ArrayList<>();

        int total = Arrays.stream(picks).sum();
        for (int i = 0; i < minerals.length; i += 5) {
            if (total == 0) break;

            int d = 0, ir = 0, st = 0;
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;

                String str = minerals[j];
                int value = str.equals("iron") ? 1 : str.equals("stone") ? 2 : 0;
                d += arr[0][value];
                ir += arr[1][value];
                st += arr[2][value];
            }

            list.add(new Mineral(d, ir, st));
            total--;
        }

        Collections.sort(list, ((a, b) -> (b.stone - a.stone)));
        for (Mineral m : list) {
            if(picks[0] > 0) {
                answer += m.dia;
                picks[0]--;
            } else  if(picks[1] > 0) {
                answer += m.iron;
                picks[1]--;
            }else if(picks[2] > 0) {
                answer += m.stone;
                picks[2]--;
            }
        }

        return answer;
    }

    static class Mineral {
        int dia, iron, stone;

        Mineral(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2},
                new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
    }
}
