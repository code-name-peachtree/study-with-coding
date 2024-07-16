package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B25381_ABBC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'A') a.add(i);
            else if(arr[i] == 'B') b.add(i);
            else {
                if (!b.isEmpty() && b.peek() < i) {
                    b.poll();
                    cnt++;
                }
            }
        }

        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.peek() < b.peek()) {
                a.poll();
                b.poll();
                cnt++;
            } else b.poll();
        }

        System.out.println(cnt);
    }
}
