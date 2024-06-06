package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d + 1]; // 번호마다 먹은 스시 개수 저장
        visited[c]++;
        int answer = 1; // k 크기 이내에서 먹은 중복없는 스시 개수

        for (int i = 0; i < k; i++) {  // k 개 만큼 담기
            if (visited[arr[i]] == 0) answer++;
            visited[arr[i]]++;
        }

        int cnt = answer;  // 찬스까지 고려해 먹을 수 있는 개수
        for (int i = 1; i < n; i++) {
            visited[arr[i-1]]--;
            if(visited[arr[i-1]]==0) cnt--;

            if(visited[arr[(i+k-1) % n]] == 0) cnt++;
            visited[arr[(i+k-1) %n]]++;

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
