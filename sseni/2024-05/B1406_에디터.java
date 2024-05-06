package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class B1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Character> list = new LinkedList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }

        int n = Integer.parseInt(br.readLine());
        ListIterator<Character> listIterator = list.listIterator(list.size());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd){
                case 'L' -> {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                }
                case 'D' -> {
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                }
                case 'B' -> {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                }
                case 'P' -> {
                    char c = st.nextToken().charAt(0);
                    listIterator.add(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
