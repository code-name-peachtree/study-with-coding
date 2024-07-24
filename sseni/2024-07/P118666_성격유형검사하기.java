package com.example.algorithm;

import java.util.HashMap;

// RT
// CF
// JM
// AN
public class P118666_성격유형검사하기 {
    public static String solution(String[] survey, int[] choices) {
        char[][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (char[] t : type) { // 점수 기록 맵 초기화
            hm.put(t[0], 0);
            hm.put(t[1], 0);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < choices.length; i++) { // 점수 기록
            if (choices[i] > 4) {
                hm.put(survey[i].charAt(1), hm.get(survey[i].charAt(1)) + score[choices[i]]);
            } else {
                hm.put(survey[i].charAt(0), hm.get(survey[i].charAt(0)) + score[choices[i]]);
            }
        }

        for (char[] t : type) { // 지표 별 점수 비교 후 유형 추가
            answer.append((hm.get(t[1]) <= hm.get(t[0])) ? t[0] : t[1]);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}
