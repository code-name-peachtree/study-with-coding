package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 빼기는 항상 나중에 계산하는 게 최솟값이 됨 -> 빼기 기준 split
public class B1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("-");

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            int tmp = 0;

            String[] str = s[i].split("\\+");
            for (int j = 0; j < str.length; j++) {
                tmp += Integer.parseInt(str[j]);
            }

            if(answer == Integer.MAX_VALUE) answer = tmp;
            else answer -= tmp;
        }

        System.out.println(answer);
    }
}
