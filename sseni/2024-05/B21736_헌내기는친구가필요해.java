package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21736_헌내기는친구가필요해 {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        int answer = dfs(x, y, 0);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    static int dfs(int x, int y, int cnt) {
        int cx = x;
        int cy = y;

        if (arr[cx][cy] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
            if (arr[nx][ny] == 'X' || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            cnt = dfs(nx, ny, cnt);
        }

        return cnt;
    }
}
