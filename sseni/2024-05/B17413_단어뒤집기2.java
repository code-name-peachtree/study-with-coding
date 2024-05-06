package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);

            if (c == '<') {
                if (tmp.length() != 0) {
                    sb.append(tmp.reverse());
                    tmp = new StringBuilder();
                }

                while (i < str.length() && str.charAt(i) != '>') {
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append('>');
                i++;

                while (i < str.length() && str.charAt(i) != '<') {
                    if (str.charAt(i) != ' ') {
                        tmp.append(str.charAt(i));
                    } else {
                        sb.append(tmp.reverse()).append(" ");
                        tmp = new StringBuilder();
                    }
                    i++;
                }

                sb.append(tmp.reverse());
                tmp = new StringBuilder();
            } else {
                if (c != ' ') {
                    tmp.append(c);
                } else if(tmp.length() != 0) {
                    sb.append(tmp.reverse()).append(" ");
                    tmp = new StringBuilder();
                }
                i++;
            }
        }

        if (tmp.length() != 0) {
            sb.append(tmp.reverse());
        }

        System.out.println(sb);
    }
}
