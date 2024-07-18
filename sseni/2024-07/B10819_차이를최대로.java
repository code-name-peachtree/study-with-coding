package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B10819_차이를최대로 {
    static int n, answer;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        dfs(0, new ArrayList<>());

        System.out.println(answer);
    }

    static void dfs(int cnt, List<Integer> list) {
        if (cnt == n) {
            answer = Math.max(answer, cal(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                dfs(cnt + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    static int cal(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(list.get(i) - list.get(i + 1));
        }

        return sum;
    }
}
