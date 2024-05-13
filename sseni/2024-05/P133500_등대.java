package com.example.algorithm;

import java.util.ArrayList;
import java.util.List;

public class P133500_등대 {
    static int num, answer = 0;
    static List<List<Integer>> list = new ArrayList<>();

    public static int solution(int n, int[][] lighthouse) {
        num = n;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < lighthouse.length; i++) {
            list.get(lighthouse[i][0]).add(lighthouse[i][1]);
            list.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }

        dfs(1, 0);
        return answer;
    }

    static int dfs(int current, int before) {
        if (list.get(current).size() == 1 && list.get(current).get(0) == before) {
            return 1;
        }

        int tmp = 0;
        for (int i = 0; i < list.get(current).size(); i++) {
            int next = list.get(current).get(i);

            if(next == before) continue;
            tmp += dfs(next, current);
        }

        if(tmp == 0) return 1;

        answer++;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}}));
    }
}
