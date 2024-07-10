package com.example.algorithm;

import java.util.Arrays;
import java.util.HashSet;

public class P12981_영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int[] arr = new int[n];
        arr[0] = 1;

        HashSet<String> hs = new HashSet<>(); // 단어 저장
        hs.add(words[0]);

        char start = words[0].charAt(words[0].length() - 1); // 다음 단어 시작 문자여야 함
        int turn = 1 % n; // 순서

        for (int i = 1; i < words.length; i++) {
            turn %= n;

            if (start == words[i].charAt(0) && !hs.contains(words[i])) {
                hs.add(words[i]);
                arr[turn]++;
                start = words[i].charAt(words[i].length() - 1);
                turn++;
            } else {
                answer[0] = turn + 1;
                answer[1] = arr[turn] + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,
                new String[]{"tank", "kick", "know", "wheel",
                        "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5,
                new String[]{"hello", "observe", "effect", "take", "either", "recognize",
                        "encourage", "ensure", "establish", "hang", "gather", "refer", "reference",
                        "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2,
                new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
