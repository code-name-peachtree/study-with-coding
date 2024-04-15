package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// end 범위를 실수했다.
public class B6236_용돈관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int start = max, end = 10_000 * 100_000;
        while (start <= end) {
            int mid = (start + end) / 2;

            // 몇 번 인출하는지 카운트
            int cnt = 1, k = mid;
            for (int i = 0; i < n; i++) {
                k -= arr[i];

                if (k < 0) {
                    cnt++;
                    k = mid - arr[i];
                }
            }

            // 횟수가 m 보다 작거나 같으면, 인출 금액을 줄여도 됨
            if (cnt <= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
