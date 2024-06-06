package com.example.algorithm;

import java.util.HashMap;

public class P258712_가장많이받은선물 {
    public static int solution(String[] friends, String[] gifts) {
        int length = friends.length;

        HashMap<String, Integer> hm = new HashMap<>();
        int[] degree = new int[length];
        int[][] arr = new int[length][length];

        for (int i = 0; i < length; i++) {
            hm.put(friends[i], i);
        }

        for (String g : gifts) {
            String[] str = g.split(" ");
            int x = hm.get(str[0]);
            int y = hm.get(str[1]);
            degree[x]++;
            degree[y]--;
            arr[x][y]++;
        }

        int answer = 0;
        for (int i = 0; i < length; i++) {
            int cnt = 0;
            for (int j = 0; j < length; j++) {
                if(i == j) continue;

                if (arr[i][j] > arr[j][i]) cnt++;
                if(arr[i][j] == arr[j][i] && degree[i] > degree[j]) cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
    }
}
