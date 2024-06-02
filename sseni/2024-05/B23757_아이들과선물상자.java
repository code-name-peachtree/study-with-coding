package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B23757_아이들과선물상자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int children = Integer.parseInt(st.nextToken());

            if (!pq.isEmpty() && pq.peek() >= children) {
                pq.add(pq.peek() - children);
                pq.poll();
            } else {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? 1 : 0);
    }
}
