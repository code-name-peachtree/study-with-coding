package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1=동, 2=서, 3=남, 4=북
// 1,2 가로 중 가장 긴 길이 찾기 = 160
// 3,4 세로 중 가장 긴 길이 찾기 = 50
public class B2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int maxH = 0, maxW = 0;
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());

            if (d == 1 || d == 2) maxW = Math.max(maxW, arr[i]);
            if (d == 3 || d == 4) maxH = Math.max(maxH, arr[i]);
        }

        int sum = arr[0] * arr[5];
        for (int i = 0; i < 5; i++) {
            sum += arr[i] * arr[i + 1];
        }

        System.out.println((maxH * maxW - (3 * maxH * maxW - sum)) * n);
    }
}
