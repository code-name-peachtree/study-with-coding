package com.example.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P138476_귤고르기 {
    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : tangerine) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(hm.values());
        list.sort((a, b) -> b - a);

        int answer = 0, sum = 0;
        for (int num : list) {
            answer++;

            if (sum + num >= k) break;
            else sum += num;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}
