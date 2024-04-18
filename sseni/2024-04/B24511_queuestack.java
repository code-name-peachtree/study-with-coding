package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// stack 은 push 하고 pop 하면, 제자리다 (queue 만 고려)
public class B24511_queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[n];
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if(Integer.parseInt(st.nextToken()) == 0) {
                check[i] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] input = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // queue 인 원소만 저장
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                queue.add(arr[i]);
            }
        }

        // deque 에, 큐에 저장했던 원소 처음 위치에 추가
        Deque<Integer> deque = new LinkedList<>();
        while (!queue.isEmpty()) {
            deque.addFirst(queue.poll());
        }

        // 1. add - 마지막 위치에 원소 추가
        // 2. poll - 처음 위치의 원소 제거 - 리턴값 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            deque.addLast(input[i]);
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}