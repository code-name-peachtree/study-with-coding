package com.example.algorithm;

import java.util.TreeSet;

public class P131701_연속부분수열합의개수 {
    public static int solution(int[] elements) {
        TreeSet<Integer> ts = new TreeSet<>();

        int n = elements.length; // 5
        for (int i = 1; i <= n; i++) {  // ex. i = 2 (길이가 2라고 가정)
            for (int j = 0; j < n; j++) {  // j = 0, 1, 2, 3 ...
                int sum = 0;
                for (int k = j; k < j + i; k++) { // k = 0, 1, 2, 3 부터 시작, 2, 3, 4, 5 까지
                    sum += elements[k % n];
                }
                ts.add(sum);
            }
        }

        return ts.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
    }
}