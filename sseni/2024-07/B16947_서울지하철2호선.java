package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B16947_서울지하철2호선 {
    static int n;
    static List<Integer>[] list;
    static boolean[] visited, check;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        // 순환선 확인 (순환선이 아니면 check[i] 가 false)
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                visited = new boolean[n + 1];
                dfs(i, i, 0);
            }
        }

        answer = new int[n + 1];
        visited = new boolean[n + 1];

        // 지선 거리 계산 (시작은 순환선에서)
        for (int i = 1; i <= n; i++) {
            if (check[i] && list[i].size() > 2) {
                search(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    static boolean dfs(int start, int i, int cnt) {
        for (int next : list[i]) {
            if (next == start) {
                // 바로 돌아오는 경우를 방지 (ex. 4에서 시작했는데 6 갔다가 4인 경우 = cnt 가 1)
                if(cnt > 1) return check[i] =  true;
                else continue;
            }

            // 다음이 사이클 || 현재가 사이클 || 이미 방문한 곳
            if(check[next] || check[i] || visited[next]) continue;

            visited[next] = true;
            check[i] = dfs(start, next, cnt + 1);
        }

        return check[i];
    }

    static void search(int i) {
        for (int next : list[i]) {
            if(check[next] || answer[next] > 0) continue;

            answer[next] = answer[i] + 1;
            search(next);
        }
    }
}
