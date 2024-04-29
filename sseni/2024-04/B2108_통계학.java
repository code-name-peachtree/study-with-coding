package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int cnt = 0, max = -1, mod = arr[0];
        boolean check = false;
        for (int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i+1]) cnt++;
            else cnt = 0;

            if (max < cnt) {
                max = cnt;
                mod = arr[i];
                check = true;
            } else if (max == cnt && check) {
                mod = arr[i];
                check = false;
            }
        }

        System.out.println(Math.round(sum / n));
        System.out.println(arr[(n - 1) / 2]);
        System.out.println(mod);
        System.out.println(arr[n - 1] - arr[0]);
    }
}
