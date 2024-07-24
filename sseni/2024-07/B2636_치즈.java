package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2636_치즈 {
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cheese = 0;
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) cheese++;
            }
        }

        int answer = 0, time = 0;
        while (cheese != 0) {
            answer = cheese;
            time++;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            visited = new boolean[n][m];
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] point = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = point[0] + dx[d];
                    int ny = point[1] + dy[d];

                    if(nx < 0 || ny < 0 || n <= nx || m <= ny || visited[nx][ny])  continue;
                    visited[nx][ny] = true;

                    if (arr[nx][ny] == 1) {
                        cheese--;
                        arr[nx][ny] = 0;
                    } else {
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println(time);
        System.out.println(answer);
    }
}
