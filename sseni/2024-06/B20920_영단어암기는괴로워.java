package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20920_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length() < m) continue;
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue(), entry.getKey().length()));
        }

        list.sort((a, b) -> {
            if(a.num != b.num) return Integer.compare(b.num, a.num);
            else if(a.length != b.length) return Integer.compare(b.length, a.length);
            else return a.str.compareTo(b.str);
        });

        StringBuilder sb = new StringBuilder();
        for (Word word : list) {
            sb.append(word.str).append("\n");
        }

        System.out.println(sb);
    }

    static class Word {
        String str;
        int num;
        int length;

        Word(String str, int num, int length) {
            this.str = str;
            this.num = num;
            this.length = length;
        }
    }
}
