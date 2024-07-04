package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최대 거리 차이가 최소가 되도록, 휴게소를 M개 설치하기
// 휴게소 거리 차이를 기준으로 이탐
public class B1477_휴게소세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr[0] = 0;
        arr[n + 1] = l;
        Arrays.sort(arr);

        int start = 1, end = l - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0; // 현재 휴게소 사이에 총 몇 개의 휴게소를 설치할 수 있는지
            for (int i = 1; i < arr.length; i++) {
                sum += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if (sum > m) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(start);
    }
}
